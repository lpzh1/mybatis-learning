package tk.mybatis.sample.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.sample.model.SysUser;

import java.util.List;

public interface UserMapper {

    SysUser findUserById(@Param("id") Long id);
    List<SysUser> findAll();

    void saveUser(SysUser user);

    // 一对一映射: 自动映射
    SysUser selectUserAndRoleById(Long id);
    // 一对一映射: resultMap映射
    SysUser selectUserAndRoleById2(Long id);
    // 一对一映射：基于resultMap的子元素 association 嵌套查询
    SysUser selectUserAndRoleByIdSelect(Long id);

    // 一对多：查询所有用户及其对应的角色
    // 采用表关联查询方式
    List<SysUser> selectAllUserAndRoles();

    // 一对多: 用户==> 角色 查询所有用户及其关联的角色
    // 采用内嵌查询，懒加载的方式
    List<SysUser> selectAllUserAndRolesSelect();

    // 一对多: 用户==> 角色 根绝id查询用户及其关联的角色
    // 采用内嵌查询，懒加载的方式
    SysUser selectUserById(Long id);
}
