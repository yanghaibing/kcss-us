package com.kcss.admin.auth.privilege;

import com.kcss.admin.auth.privilege.domain.PrivilegeDomain;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PrivilegeMapper {

    @Select("SELECT P.* FROM T_ADMIN_ROLE_REL ARR " +
            " LEFT JOIN T_ADMIN A ON A.ID = ARR.ADMIN_ID " +
            " LEFT JOIN T_ROLE R ON R.ID = ARR.ROLE_ID " +
            " LEFT JOIN T_PRIVILEGE_ROLE_REL PRR ON PRR.ROLE_ID = R.ID " +
            " LEFT JOIN T_PRIVILEGE P ON P.ID = PRR.PRIVILEGE_ID " +
            "WHERE A.ID = #{adminId}")
    List<PrivilegeEntity> findPrivilegesById(long adminId);

    @Select("SELECT * FROM T_ROLE WHERE STATUS='ACTIVE'")
    List<RoleEntity> getAllActiveRoles();

    @Select("SELECT PRIVILEGE.*\n" +
            "FROM T_ROLE ROLE\n" +
            "  LEFT JOIN T_PRIVILEGE_ROLE_REL ROLEREL ON ROLEREL.ROLE_ID = ROLE.ID\n" +
            "  LEFT JOIN T_PRIVILEGE PRIVILEGE ON PRIVILEGE.ID = ROLEREL.PRIVILEGE_ID\n" +
            "WHERE ROLE.ID=#{roleId}")
    List<PrivilegeEntity> getAllPrivilegeByRole(long roleId);

    @Insert("INSERT INTO T_ADMIN_ROLE_REL (admin_id, role_id) VALUES (#{adminId}, #{roleId});")
    int grantPrivilege(@Param("adminId") long adminId, @Param("roleId") Long roleId);

    @Select("SELECT role.* FROM T_ADMIN_ROLE_REL rel LEFT JOIN T_ROLE role ON rel.role_id = role.id WHERE rel.admin_id=#{adminId}")
    List<RoleEntity> findRoleByAdmin(long adminId);

    @Delete("DELETE FROM T_ADMIN_ROLE_REL WHERE admin_id=#{adminId}")
    int revokeAllPrivilege(long adminId);

    @Select("SELECT id, name, type, description FROM T_PRIVILEGE WHERE STATUS='ACTIVE' ORDER BY id, type desc")
    List<PrivilegeDomain> getAllPrivilege();
}
