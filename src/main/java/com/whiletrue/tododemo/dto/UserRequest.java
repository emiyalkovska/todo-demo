package com.whiletrue.tododemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}