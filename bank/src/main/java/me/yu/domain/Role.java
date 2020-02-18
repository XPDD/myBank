package me.yu.domain;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Integer id;
    private String rname;
    private List<User> users;
}
