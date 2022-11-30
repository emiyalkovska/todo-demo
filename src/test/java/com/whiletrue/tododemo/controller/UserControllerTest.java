package com.whiletrue.tododemo.controller;

import com.whiletrue.tododemo.dto.UserRequest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import javax.annotation.PostConstruct;

import static io.restassured.RestAssured.with;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    void registerUser() {
        UserRequest userRequest = new UserRequest("firstNameTest", "lastNameTest", "usernameTest", "passwordTest");

        with().body(userRequest)
                .contentType(ContentType.JSON)
                .when()
                .post(uri + "/registration")
                .then()
                .statusCode(200);
    }

}