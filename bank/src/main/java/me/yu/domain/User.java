package me.yu.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String profile;//简介
    private String photo;//图片地址
    private Double save;//存款
    private List<Role> roles;//角色
    private List<Transfer> transfers;//转账信息
}
