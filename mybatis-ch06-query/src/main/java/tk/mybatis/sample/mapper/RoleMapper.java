package tk.mybatis.sample.mapper;

import tk.mybatis.sample.model.SysRole;

import java.util.List;

public interface RoleMapper {

    SysRole selectRoleById(Long id);

    // 根据 userId 查询指定用户拥有的角色
    List<SysRole> selectRoleByUserId(Long userId);

    // 根据userId查询角色，并且在根据角色状态（enabled）是否可用决定是否返回角色对应的权限
    List<SysRole> selectRoleByUserIdChoose(Long userId);
}
