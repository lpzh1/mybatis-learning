package tk.mybatis.sample.mapper;

import org.apache.ibatis.annotations.CacheNamespaceRef;
import tk.mybatis.sample.model.SysRole;

// @CacheNamespaceRef(RoleMapper.class)
public interface RoleMapper {

    SysRole selectById(Long l);
}
