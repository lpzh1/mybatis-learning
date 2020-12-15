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
    public void saveUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SysUser user = new SysUser();
        user.setUserName("林青霞");
        user.setUserPassword("111");
        int res = sqlSession.insert("saveUser", user);
        // FIXME 注意：更新和保存操作，要手动提交事务，不然自动回滚，看不到效果
        sqlSession.commit();
    }

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
