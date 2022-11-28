package com.whiletrue.tododemo.service;

import com.whiletrue.tododemo.dto.UserRequest;
import com.whiletrue.tododemo.dto.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserResponse createUser(UserRequest userRequest);
}
