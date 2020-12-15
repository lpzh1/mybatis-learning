package tk.mybatis.sample.model;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser {
    private Long id ;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo; // 简介
    private byte[] headImage;
    private Date createTime;
}
