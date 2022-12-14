package com.whiletrue.tododemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.whiletrue.tododemo.dto.UserRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public User(UserRequest userRequest) {
        this.firstName = userRequest.getFirstName();
        this.lastName = userRequest.getLastName();
        this.username = userRequest.getUsername();
        this.password = userRequest.getPassword();
    }

}
