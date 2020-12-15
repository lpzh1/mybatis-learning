package tk.mybatis.sample.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.sample.util.SqlSessionUtil;

public class PrivilegeMapperTest {


    @Test
    public void selectPrivilegeByRoleId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        PrivilegeMapper pm = sqlSession.getMapper(PrivilegeMapper.class);
        Long roleId = 1L;
        pm.selectPrivilegeByRoleId(roleId);

    }
}
