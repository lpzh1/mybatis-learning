package tk.mybatis.sample.mapper;

import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.sample.model.SysRole;

@CacheNamespaceRef(RoleMapper.class)
public interface RoleMapper {

    SysRole selectById(Long l);

    @Update({"update sys_role set role_name=#{roleName} where id=#{id}"})
    int updateRoleById(SysRole role);
}
