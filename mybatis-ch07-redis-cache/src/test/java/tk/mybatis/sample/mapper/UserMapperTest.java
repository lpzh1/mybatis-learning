package tk.mybatis.sample.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.sample.model.SysUser;
import tk.mybatis.sample.util.SqlSessionUtil;

import java.util.List;

@Slf4j
public class UserMapperTest {
    @Test
    public void findAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        List<Object> users = sqlSession.selectList("findAll");
        log.info("{}",users);
    }
    @Test
    public void findUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Long id = 1L;

        SysUser user = userMapper.findUserById(id);

        log.info("{}",user);
    }

    // 一对一关联
    // 查询
    @Test
    public void selectUserAndRoleById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        SysUser user = userMapper.selectUserAndRoleById(1L);

        log.info("{}",user);

        // 手动关闭，刷新一级缓存
        sqlSession.close();
    }

}
