package tk.mybatis.sample.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.sample.model.SysRole;
import tk.mybatis.sample.util.SqlSessionUtil;

@Slf4j
public class RoleMapperTest {


    // 更新操作会清空二级换存中数据
    @Test
    public void updateRoleById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        SysRole sysRole = new SysRole();
        sysRole.setId(1L);
        sysRole.setRoleName("管理员00");

        int i = mapper.updateRoleById(sysRole);
        log.info("{}",i);
        sqlSession.commit();
        // 关闭连接
        // sqlSession.close();
    }

    @Test
    public void selectById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

        SysRole role = mapper.selectById(1L);
        log.info("{}",role);

        //TODO 只有手动关闭 sqlSession 才能让一级缓存进入二级缓存
        sqlSession.close();
    }
}
