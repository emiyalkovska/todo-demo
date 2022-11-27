package com.whiletrue.tododemo.dto;

import com.whiletrue.tododemo.entity.User;
import lombok.Data;

@Data
public class UserResponse {

    private String firstName;
    private String lastName;
    private String username;

    public UserResponse(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
    }
}
