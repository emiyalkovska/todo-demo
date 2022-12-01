package com.whiletrue.tododemo.controller;

import com.whiletrue.tododemo.dto.TaskRequest;
import com.whiletrue.tododemo.dto.UserRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.List;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskControllerTest {

    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Order(0)
    @Test
    void createUser() {
        UserRequest userRequest = new UserRequest("firstNameTest", "lastNameTest", "test", "test");

        with().body(userRequest)
                .contentType(ContentType.JSON)
                .when()
                .post(uri + "/registration")
                .then()
                .statusCode(200);
    }

    @Order(1)
    @Test
    void createTask() {
        TaskRequest taskRequest = new TaskRequest("nameTest", "descriptionTest", Instant.parse("2022-12-01T11:59:00.000Z"), true);

        getAuthorizedRequest().body(taskRequest)
                .contentType(ContentType.JSON)
                .when()
                .post(uri + "/tasks")
                .then()
                .statusCode(200);
    }

    @Order(2)
    @Test
    void getTasks() {

        getAuthorizedRequest()
                .when()
                .get(uri + "/tasks")
                .then()
                .statusCode(200)
                .body("", Matchers.instanceOf(List.class))
                .body("name[0]", equalTo("nameTest"))
                .body("description[0]", equalTo("descriptionTest"))
                .body("dueDateTime[0]", equalTo("2022-12-01T11:59:00Z"))
                .body("completed[0]", equalTo(true));
    }

    @Order(3)
    @Test
    void updateTask() {
        TaskRequest taskRequest = new TaskRequest("nameTest", "descriptionTest", Instant.parse("2022-12-01T11:59:00.000Z"), false);

        getAuthorizedRequest().body(taskRequest)
                .contentType(ContentType.JSON)
                .when()
                .put(uri + "/tasks/2")
                .then()
                .statusCode(200)
                .body("completed", equalTo(false));
    }

    @Order(4)
    @Test
    void deleteTask() {
        getAuthorizedRequest()
                .when()
                .delete(uri + "/tasks/2")
                .then()
                .statusCode(200);
    }

    private RequestSpecification getAuthorizedRequest() {
        return RestAssured.given().auth().basic("test", "test");
    }
}