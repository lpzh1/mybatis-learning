package tk.mybatis.sample.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
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
        Long id = 1L;
        Object user = sqlSession.selectOne("findUserById", id);
        log.info("{}",user);
    }
}
