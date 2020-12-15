package tk.mybatis.sample.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.sample.model.SysRole;
import tk.mybatis.sample.util.SqlSessionUtil;

import java.util.List;

@Slf4j
public class RoleMapperTest {

    // 用户==>角色
    // 一对多
    // 嵌套查询
    @Test
    public void selectRoleByUserId() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        // TODO 动手实践： 将 RoleMapper。xml中的rolePrivilegeListMapSelect的collection元素的fetchType属性在eager和lazy间切换，
        //  查看懒加载执行的日志信息
        Long userId = 1L;
        mapper.selectRoleByUserId(userId);
    }

    // 一对多
    @Test
    public void selectRoleByUserIdChoose() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

        List<SysRole> sysRoles = mapper.selectRoleByUserIdChoose(1L);

        log.info("{}", sysRoles);
        // 观察结果：第二个role的privilege属性为null，符合预期
        for (SysRole sysRole : sysRoles) {
            log.info("{}", sysRole);

        }
    }


    // 枚举类型没有提供转器，会报错
    @Test
    public void selectRoleById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

        SysRole sysRole = mapper.selectRoleById(2L);
        log.info("{}",sysRole);
    }
}
