package com.kcss.admin.auth.privilege;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface CheckPrivilege {

    Privilege[] value();

}
