package tk.mybatis.sample.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.sample.model.SysUser;

import java.util.List;

public interface UserMapper {

    SysUser findUserById(@Param("id") Long id);
    List<SysUser> findAll();

    void saveUser(SysUser user);
}
