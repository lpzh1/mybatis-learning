package tk.mybatis.sample.param;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// mybatis 查询条件
@Getter@Setter
public class SysUserParam {
    private Long id ;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo; // 简介
    private byte[] headImg;
    private Date createTime;
}
