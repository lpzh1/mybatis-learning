package tk.mybatis.sample.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.sample.model.SysUser;

import java.util.List;

public interface UserMapper {

    @Select({"select * from sys_user where id = #{id}"})
    SysUser findUserById(@Param("id") Long id);

    @Select("select * from sys_user")
    List<SysUser> findAll();

    @Insert("insert into sys_user(user_name,user_password) values(#{userName},#{userPassword})")
    void saveUser(SysUser user);
}
