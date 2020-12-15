package tk.mybatis.sample.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.sample.model.SysPrivilege;
import tk.mybatis.sample.model.SysRole;
import tk.mybatis.sample.model.SysUser;
import tk.mybatis.sample.util.SqlSessionUtil;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserMapperTest {
    @Test
    public void findAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        List<Object> users = sqlSession.selectList("findAll");
        log.info("{}", users);
    }

    @Test
    public void findUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Long id = 1L;
        Object user = sqlSession.selectOne("findUserById", id);
        log.info("{}", user);
    }

    // 一对一
    @Test
    public void selectUserAndRoleById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 假设一个用户只关联一个角色
        Long id = 1L;
        SysUser sysUser = userMapper.selectUserAndRoleById2(id);
        log.info("{}", sysUser);
    }

    // 一对一: 嵌套查询
    // 延迟加载（懒加载）
    @Test
    public void selectUserAndRoleByIdSelect() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Long id = 1L;
        SysUser user = userMapper.selectUserAndRoleByIdSelect(id);
        // log.info("{}",user);
        // Assert.assertNotNull(user);
        System.out.println("------调用getRole");
        // log.info("{}",user.getRole());
        Assert.assertNotNull(user.getRole());

        // TODO 注意：输出对象会调用对象本身toString方法，影响延迟加载的实验结果
        // TODO 但是为什么debug的时候，在  user.getRole() 前面打断点，控制台还是先输出了查询sys_role 的日志
        // TODO  但是不使用debug启动时，又是符合预期的结果
        //TODO 参考 https://blog.csdn.net/weixin_42130471/article/details/86626404
    }

    // 一对多：查询所有用户及其对应的角色
    // 表关联查询，一次查询所有信息，然后再做关联映射
    @Test
    public void selectAllUserAndRoles(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<SysUser> users = userMapper.selectAllUserAndRoles();
        log.info("用户数:{}",users.size());
        // 取出第一个用户的角色
        log.info("第一个用户有多少个角色？{}",users.get(0).getRoleList().size());
    }

    // 一对多：内嵌查询(可以实现懒加载)
    @Test
    public void selectAllUserAndRolesSelect(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // userMapper.selectAllUserAndRolesSelect();
        SysUser user = userMapper.selectUserById(1L);
        log.info("用户:{}",user);
        log.info("角色:{}",user.getRoleList());
        List<SysPrivilege> privileges = new ArrayList<>();
        for (SysRole role:user.getRoleList()) {
            for (SysPrivilege privilege:role.getPrivilegeList()) {
                privileges.add(privilege);
            }
        }
        log.info("权限:{}",privileges);
    }
}
