package tk.mybatis.sample.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.sample.model.SysUser;
import tk.mybatis.sample.param.SysUserParam;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    SysUser findUserById(@Param("id") Long id);

    List<SysUser> findAll();

    void saveUser(SysUser user);

    /**
     * 动态条件查询用户列表
     * 查询中使用 if 标签
     *
     * @param param
     * @return
     */
    List<SysUser> findByUsernameAndEmail(SysUserParam param);

    /**
     * 更新中使用 if 标签
     *
     * @param user
     * @return
     */
    int updateByIdSelective(SysUser user);

    /**
     * choose when 标签
     *
     * @param param
     * @return
     */
    SysUser findByIdOrUserName(SysUserParam param);

    /**
     * 演示 where 标签的用法
     *
     * @param param
     * @return
     */
    List<SysUser> findByUser(SysUserParam param);

    /**
     * set 标签
     *
     * @param user
     * @return
     */
    int updateById(SysUser user);

    /**
     * 使用 trim 标签代替 where 标签
     *
     * @param param
     * @return
     */
    List<SysUser> findUser(SysUserParam param);

    /**
     * 在更新SQL中，使用 trim 标签（代替 set 标签）
     *
     * @param user
     * @return
     */
    int updateUserById(SysUser user);

    /**
     * 使用 foreach标签 遍历List集合参数
     *
     * @param idsList
     * @return
     */
    List<SysUser> findByIdsList(@Param("ids") List<Long> idsList);

    /**
     * foreach标签实现批量插入
     *
     * @param userList
     * @return
     */
    int saveUserList(@Param("list") List<SysUser> userList);

    /**
     * 通过map更新指定的列
     * @param map
     * @return
     */
    public int updateByMap(Map<String,Object> map);
}
