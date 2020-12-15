package tk.mybatis.sample.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.mybatis.sample.type.Enabled;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class SysRole {
    private Long id;
    private String roleName;
    // private Long enabled; // 有效标志
    private Enabled enabled;
    private Long createBy; // 创建人ID
    private Date createTime; // 创建时间

    // 用户
    // private SysUser user;

    // 角色-->权限 一对多关系
    private List<SysPrivilege> privilegeList;
}
