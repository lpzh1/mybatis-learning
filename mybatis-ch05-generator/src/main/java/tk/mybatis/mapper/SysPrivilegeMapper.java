package tk.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.model.SysPrivilege;
import tk.mybatis.model.SysPrivilegeExample;

public interface SysPrivilegeMapper {
    int countByExample(SysPrivilegeExample example);

    int deleteByExample(SysPrivilegeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysPrivilege record);

    int insertSelective(SysPrivilege record);

    List<SysPrivilege> selectByExample(SysPrivilegeExample example);

    SysPrivilege selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysPrivilege record, @Param("example") SysPrivilegeExample example);

    int updateByExample(@Param("record") SysPrivilege record, @Param("example") SysPrivilegeExample example);

    int updateByPrimaryKeySelective(SysPrivilege record);

    int updateByPrimaryKey(SysPrivilege record);
}