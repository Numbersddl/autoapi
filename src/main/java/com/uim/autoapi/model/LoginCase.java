package com.uim.autoapi.model;

import lombok.Data;

@Data
public class LoginCase {
    private String realmId;
    private String userName;
    private String password;
}
