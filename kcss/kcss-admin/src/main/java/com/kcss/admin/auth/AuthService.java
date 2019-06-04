package com.kcss.admin.auth;

import com.kcss.admin.admin.AdminEntity;
import com.kcss.admin.admin.AdminStatus;
import com.kcss.core.exception.AdminErrorConstants;
import com.kcss.core.util.security.PasswordEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private PasswordEncryptor encryptor;

    @Autowired
    private AuthMapper authMapper;

    public AdminEntity login(String mobile, String password) {
        AdminEntity entity = authMapper.findOneByMobile(mobile);
        if (entity == null || entity.getStatus() == AdminStatus.FREEZE || entity.getStatus() == AdminStatus.DISABLED|| entity.getFailedLoginCount() > 10) {
            logger.warn("user {} login failed", mobile);
            throw new AuthException(AdminErrorConstants.ERR_ADMIN_AUTH_ACCESS_DENIED, "no such admin user or user non active"); // TODO
        }
        if (!encryptor.matches(password, entity.getPassword())) {
            logger.warn("user {} login failed, invalid password", mobile);
            handleLoginFailed(entity.getMobile());
            throw new AuthException(AdminErrorConstants.ERR_ADMIN_AUTH_ACCESS_DENIED, "invalid password"); // TODO
        }
        handleLoginSuccess(entity.getMobile());
        return entity;
    }

    //product offon
    public void handleLoginSuccess(String mobile) {

        authMapper.updateLoginSuccessByMobile(mobile);
    }

    public void handleLoginFailed(String mobile) {

        authMapper.updateLoginFailedByMobile(mobile);
    }

}
