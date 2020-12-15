package tk.mybatis.sample.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUser implements Serializable {
    private Long id ;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo; // 简介
    private byte[] headImage;
    private Date createTime;

    // 一对一关联
    private SysRole role;
}
