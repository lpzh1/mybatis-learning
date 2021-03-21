package tk.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.model.SysRolePrivilege;
import tk.mybatis.model.SysRolePrivilegeExample;

public interface SysRolePrivilegeMapper {
    int countByExample(SysRolePrivilegeExample example);

    int deleteByExample(SysRolePrivilegeExample example);

    int insert(SysRolePrivilege record);

    int insertSelective(SysRolePrivilege record);

    List<SysRolePrivilege> selectByExample(SysRolePrivilegeExample example);

    int updateByExampleSelective(@Param("record") SysRolePrivilege record, @Param("example") SysRolePrivilegeExample example);

    int updateByExample(@Param("record") SysRolePrivilege record, @Param("example") SysRolePrivilegeExample example);
}