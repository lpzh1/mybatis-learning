package tk.mybatis.sample.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.sample.model.SysRole;
import tk.mybatis.sample.model.SysUser;
import tk.mybatis.sample.util.SqlSessionUtil;

@Slf4j
public class CacheTest {

    // 以及缓存默认是开启的，下面测试一级缓存的效果
    @Test
    public void cacheLevelOne() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Long id = 1L;
        //
        SysUser user1 = mapper.findUserById(id);
        user1.setUserName("new User name");

        SysUser user2 = mapper.findUserById(id);
        log.info("{}", user1);
        log.info("{}", user2);
        log.info("{}", user2 == user1);
        // 调用两次  查询，结果是一样。说明一级缓存起作用了
    }

    //测试二级缓存效果
    @Test
    public void cacheLevelTwo() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);


        SysRole role1 = mapper.selectById(1L);
        // 设置新的属性值
        role1.setRoleName("new role name");


        SysRole role2 = mapper.selectById(1L);

        log.info("role1:{}",role1);
        log.info("role2:{}",role2);

        // 关闭当前SqlSession
        // 一级缓存的数据会被刷新到二级缓存中
        sqlSession.close();
        // 开启新的SqlSession
        sqlSession = SqlSessionUtil.getSqlSession();
        mapper = sqlSession.getMapper(RoleMapper.class);
        log.info("\n new sqlsession \n");

        SysRole sysRole1 = mapper.selectById(1L);
        log.info("sysRole1:{}",sysRole1);
        sysRole1.setRoleName("new sysRole name");


        SysRole sysRole2 = mapper.selectById(1L);
        log.info("sysRole2:{}",sysRole2);
        // 是两个相同的实例吗？不是
        // 因为
        log.info("{}",sysRole1==sysRole2);
    }


}
