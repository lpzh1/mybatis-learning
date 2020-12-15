package tk.mybatis.sample.mapper;


import tk.mybatis.sample.model.SysPrivilege;

import java.util.List;

public interface PrivilegeMapper {
    // 根据role_id 获取角色对应的所有权限信息
    List<SysPrivilege> selectPrivilegeByRoleId(Long roleId);



}