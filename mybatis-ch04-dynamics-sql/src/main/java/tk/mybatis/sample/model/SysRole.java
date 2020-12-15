package tk.mybatis.sample.model;

import lombok.Data;

import java.util.Date;

@Data
public class SysRole {
    private Long id ;
    private String roleName;
    private Long enabled; // 有效标志
    private Long createBy; // 创建人ID
    private Date createTime; // 创建时间
}
