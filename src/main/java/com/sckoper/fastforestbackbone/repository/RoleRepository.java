package com.sckoper.fastforestbackbone.repository;

import com.sckoper.fastforestbackbone.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * 根据角色Id获取角色
     * @param roleId 角色Id
     * @return Role
     */
    public Role findRoleByRoleId(Integer roleId);

    /**
     * 根据角色名获取角色
     * @param roleName 角色名
     * @return Role
     */
    public Role findRoleByRoleName(String roleName);

    /**
     * 根据角色Id删除角色
     * @param roleId 角色Id
     */
    public void deleteRoleByRoleId(Integer roleId);

    /**
     * 根据角色名删除角色
     * @param roleName 角色名
     */
    public void deleteRoleByRoleName(String roleName);
}
