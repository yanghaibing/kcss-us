package com.kcss.admin.auth.privilege;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PrivilegeService {

    @Autowired
    private PrivilegeMapper privilegeMapper;

    public Set<Privilege> findPrivilegeSet(long adminId) {
        HashSet<Privilege> privileges = new HashSet<>();
        List<PrivilegeEntity> entities = privilegeMapper.findPrivilegesById(adminId);
        entities.forEach(entity -> privileges.add(entity.getName()));
        return privileges;
    }

    public List<RoleEntity> getAllActiveRoles() {
        return privilegeMapper.getAllActiveRoles();
    }

    public List<PrivilegeEntity> getAllPrivilegeByRole(long roleId) {
        return privilegeMapper.getAllPrivilegeByRole(roleId);
    }

    public int grantPrivilege(long adminId, Long roleId) {
        return privilegeMapper.grantPrivilege(adminId, roleId);
    }

    public int revokeAllPrivilege(long adminId) {
        return privilegeMapper.revokeAllPrivilege(adminId);
    }

    public List<RoleEntity> getRoleByAdmin(long adminId) {
        return privilegeMapper.findRoleByAdmin(adminId);
    }
}
