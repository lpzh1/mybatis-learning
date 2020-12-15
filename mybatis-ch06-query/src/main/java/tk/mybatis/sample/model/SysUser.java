package tk.mybatis.sample.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
// @ToString
public class SysUser {
    private Long id ;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo; // 简介
    private byte[] headImage;
    private Date createTime;

    // 一个用户有一个角色
    private SysRole role;

    // 一个用户有多个角色
    private List<SysRole> roleList;

}
