package com.kcss.admin.auth;

import com.kcss.admin.admin.AdminEntity;
import com.kcss.admin.auth.privilege.PrivilegeService;
import com.kcss.admin.auth.session.SessionConstants;
import com.kcss.biz.record.auth.captcha.CaptchaService;
import com.kcss.core.exception.AdminErrorConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private CaptchaService captchaService;

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/auth/login");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam("mobile") String mobile,
                                @RequestParam("password") String password,
                                @RequestParam("answer") String answer,
                                HttpServletRequest request,
                                Locale locale) {

        if (!captchaService.validate(request.getSession().getAttribute("serialId").toString(), answer)) {
            throw new AuthException(AdminErrorConstants.ERR_ADMIN_AUTH_CAPTCHA_ERROR, "error captcha");
        }

        AdminEntity entity = authService.login(mobile, password);

        httpSession.setAttribute(SessionConstants.LOGIN_FLAG, "login");
        httpSession.setAttribute(SessionConstants.OPERATOR_ID, entity.getId());
        httpSession.setAttribute(SessionConstants.OPERATOR_NAME, entity.getFullName());
        httpSession.setAttribute(SessionConstants.PRIVILEGES, privilegeService.findPrivilegeSet(entity.getId()));
        httpSession.setAttribute(SessionConstants.LOCALE, locale);
        httpSession.setAttribute(SessionConstants.OPERATOR_STATUS, entity.getStatus().name());
        httpSession.setMaxInactiveInterval(60 * 60 * 1); // 1 hour

        return ResponseEntity.ok(new HashMap<>());
    }

    @GetMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResponseEntity.ok(new HashMap<>());
    }

    @RequestMapping(path = "/captcha", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public void getImage(@RequestParam("serialId") String sid,
                         @RequestParam("width") int width,
                         @RequestParam("height") int height,
                         HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("serialId", sid);
        captchaService.genImage(sid, width, height, response, true);
    }
}
