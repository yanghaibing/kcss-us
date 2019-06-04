package com.kcss.admin.auth.privilege;

import com.kcss.admin.auth.session.AdminSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Aspect
@Component
public class CheckPrivilegeAspect {

    private final Logger logger = LoggerFactory.getLogger(CheckPrivilegeAspect.class);

    @Autowired
    private AdminSession adminSession;

    @Before(value = "@annotation(checkPrivilege)")
    public void checkPrivileges(JoinPoint joinPoint, CheckPrivilege checkPrivilege) {
        Privilege[] needPrivileges = checkPrivilege.value();
        Set<Privilege> privileges = adminSession.getPrivileges();
//        if (!privileges.containsAll(Arrays.asList(needPrivileges))) {
//            logger.warn("need privileges: {}, user {} has privileges: {} ", needPrivileges, adminSession.getName(), privileges);
//            throw new PrivilegeException("privilege check error");
//        }

        //登录用户的权限只要包含所需权限中的一个即可通过
        boolean flag = false;
        for (int i=0;i<needPrivileges.length;i++){
            if(privileges.contains(needPrivileges[i])){
                flag = true;
                break;
            }
        }

        if (!flag) {
            logger.warn("need privileges: {}, user {} has privileges: {} ", needPrivileges, adminSession.getName(), privileges);
            throw new PrivilegeException("privilege check error");
        }
    }

    public boolean check(String... privilegeStrs) {
        try {
            List<Privilege> privileges = new ArrayList<>();
            for (String s : Arrays.asList(privilegeStrs)) {
                privileges.add(Privilege.valueOf(s));
            }
            return adminSession.getPrivileges().containsAll(privileges);
        } catch (Exception e) {
            // eat exception, or else this will throw exception to freemarker
            logger.warn("exception: {}", e);
            return false;
        }
    }

}
