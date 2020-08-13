package ru.dins.shashkov.tests.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class PostNewUserSteps {
    private Response response;

    @Step
    public void addNewUserToPhoneBook() {
        RestAssured.baseURI = "http://localhost:8080";

        HashMap <String, String> newUser = new HashMap();
        newUser.put("id", "three");
        newUser.put("firstName", "to");
        newUser.put("lastName", "to");

        response = SerenityRest.given().log().body()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/users");
    }

    @Step("Post is failed")
    public void isFailed() {
        response.then().statusCode(400);
    }
}
