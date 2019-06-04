package com.kcss.admin.auth.session;

import com.kcss.admin.auth.privilege.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Set;

@Component
public class AdminSession {

    @Autowired
    private HttpSession session;

    public long getId() {
        return (Long) session.getAttribute(SessionConstants.OPERATOR_ID);
    }

    public String getName() {
        return (String) session.getAttribute(SessionConstants.OPERATOR_NAME);
    }

    @SuppressWarnings("unchecked")
    public Set<Privilege> getPrivileges() {
        return (Set<Privilege>) session.getAttribute(SessionConstants.PRIVILEGES);
    }

}
