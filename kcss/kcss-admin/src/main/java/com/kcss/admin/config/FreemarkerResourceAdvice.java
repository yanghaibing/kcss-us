package com.kcss.admin.config;

import com.kcss.admin.auth.privilege.CheckPrivilegeAspect;
import com.kcss.admin.auth.session.AdminSession;
import com.kcss.core.util.messageresource.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

@ControllerAdvice
public class FreemarkerResourceAdvice {

    @Autowired
    private ResourceUrlProvider resourceUrlProvider;

    @Autowired
    private CheckPrivilegeAspect privilegeChecker;

    @Autowired
    private AdminSession adminSession;

    @Autowired
    private MessageHelper messageHelper;

    @ModelAttribute("urls")
    public ResourceUrlProvider urls() {
        return this.resourceUrlProvider;
    }

    @ModelAttribute("priv")
    public CheckPrivilegeAspect priv() {
        return this.privilegeChecker;
    }

    @ModelAttribute("session")
    public AdminSession session() {
        return this.adminSession;
    }

    @ModelAttribute("msg")
    public MessageHelper messageHelper() {
        return this.messageHelper;
    }

}
