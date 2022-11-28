package com.whiletrue.tododemo.service.impl;

import com.whiletrue.tododemo.dto.UserRequest;
import com.whiletrue.tododemo.dto.UserResponse;
import com.whiletrue.tododemo.entity.User;
import com.whiletrue.tododemo.repository.UserRepository;
import com.whiletrue.tododemo.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {

        String hashedPassword = passwordEncoder.encode(userRequest.getPassword());
        userRequest.setPassword(hashedPassword);

        User user = new User(userRequest);

        userRepository.save(user);

        return new UserResponse(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), List.of());
    }

}
