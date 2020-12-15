package tk.mybatis.sample.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.sample.model.SysUser;

import java.util.List;

// 参照缓存不是为了解决名称空间冲突，是为了解决脏读

// 同时使用xml和注解的方式配置缓存会抛出异常
// 因为使用的是相同的名称空间
// @CacheNamespace
// 为了解决名称空间冲突出现的异常，可以使用参照缓存。这时候，注解和xml配置都实现了缓存
// @CacheNamespaceRef(UserMapper.class)
public interface UserMapper {

    SysUser findUserById(@Param("id") Long id);
    List<SysUser> findAll();

    void saveUser(SysUser user);
}
