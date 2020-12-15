package tk.mybatis.sample.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.sample.model.SysUser;
import tk.mybatis.sample.param.SysUserParam;
import tk.mybatis.sample.util.SqlSessionUtil;

import java.util.*;

@Slf4j
public class UserMapperTest {
    @Test
    public void updateByIdSelective() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        SysUser sysUser = new SysUser();
        sysUser.setId(1L); // 更新id=1的用户
        sysUser.setUserEmail("admin@mybatis.tk");

        // 返回值：SQL执行影响的行数
        int i = userMapper.updateByIdSelective(sysUser);
        //  注意：更新操作需要提交事务
        sqlSession.commit();
    }

    @Test
    public void findByUsernameAndEmail() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SysUserParam param = new SysUserParam();
        // param.setUserName("adm");
        param.setUserEmail("test@mybatis.tk");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<SysUser> users = userMapper.findByUsernameAndEmail(param);
        log.info("{}", users);
    }

    // 保存中 使用 if 标签
    @Test
    public void saveUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SysUser user = new SysUser();
        user.setUserName("章拍芝");
        user.setUserPassword("333");
        user.setUserEmail("linqingxia@mybatis.tk");
        int res = sqlSession.insert("saveUser", user);
        // FIXME 注意：更新和保存操作，要手动提交事务，不然自动回滚，看不到效果
        sqlSession.commit();
    }

    @Test
    public void findAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        List<Object> users = sqlSession.selectList("findAll");
        log.info("{}", users);
    }

    // 查询中使用 if 标签
    @Test
    public void findUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Long id = 1L;
        Object user = sqlSession.selectOne("findUserById", id);
        log.info("{}", user);
    }

    /* <choose><when> 动态SQL，最多只会拼接一个条件，相当于java中的switch */
    @Test
    public void findByIdOrUserName() {
        // 考虑三种情况：
        // 1） 只有用户名
        // 2） 只有id
        // 3） userName 和 id都为空
        // 当返回多条记录时，报错：TooManyResultsException
        // 因为接口方法声明返回值是 SysUser 而不是 List<SysUser>
        // 也就是默认了数据库中的 user_name 字段值唯一
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        SysUserParam param = new SysUserParam();
        // param.setId(1L);
        // param.setUserName("林青霞");
        SysUser sysUser = userMapper.findByIdOrUserName(param);

        log.info("{}", sysUser);
    }

    //  set 标签
    // 更新中使用 set 标签
    @Test
    public void updateById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        SysUser user = new SysUser();
        user.setId(1L);
        user.setUserEmail("admin@126.com");
        userMapper.updateById(user);
        //FIXME  注意：要提交事务
        sqlSession.commit();
    }

    //  where 标签
    @Test
    public void findByUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        SysUserParam param = new SysUserParam();
        param.setUserEmail("xia@mybatis.tk");

        userMapper.findByUser(param);
    }

    // 使用 trim 标签代替 where 标签
    @Test
    public void findUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        SysUserParam param = new SysUserParam();
        param.setId(1L);
        // param.setUserName("admin");
        List<SysUser> users = userMapper.findUser(param);

    }

    // 使用 trim 标签代替 set标签
    @Test
    public void updateUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        SysUser sysUser = new SysUser();
        sysUser.setId(1L);
        // sysUser.setUserPassword("555");
        // sysUser.setUserInfo("超级管理员");

        userMapper.updateUserById(sysUser);

        sqlSession.commit();
    }

    // 使用 foreach 标签遍历 List 集合参数
    @Test
    public void findByIdsList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Long> idsList = Arrays.asList(1L, 1001L, 1003L);
        userMapper.findByIdsList(idsList);
    }


    // 使用 foreach 实现批量插入
    @Test
    public void saveUserList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<SysUser> users = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            SysUser user = new SysUser();
            user.setUserName("test" + i);
            user.setUserPassword("test" + i);
            user.setUserEmail("test" + i + "@mybatis.tk");
            users.add(user);
        }
        userMapper.saveUserList(users);
        // 返回批量插入的自增主键值
        for (SysUser user : users) {
            log.info("{}", user.getId());
        }
    }

    // foreach 动态更新指定的列
    @Test
    public void updateByMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        //  查询条件
        map.put("id", 1L);
        // 更新其他字段
        map.put("user_email", "test@mybatis.th");
        map.put("user_password","999");
        // 执行更新
        userMapper.updateByMap(map);

    }

}
