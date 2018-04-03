package com.yuanwj.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by bmk on 17-12-21.
 */
@Data
public class User {

    private Long id;

    private String phone;

    private String email;

    private String userName;

    private String password;

    private String realName;

    private String company;

    private Boolean status;

    private String roleType;

    private Date registerDate;

    private String keyuuid;

    private Long roleId;
}
