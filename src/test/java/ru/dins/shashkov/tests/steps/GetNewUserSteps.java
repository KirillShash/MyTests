package ru.dins.shashkov.tests.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import ru.dins.shashkov.tests.users.User;

public class GetNewUserSteps {
    private Response response;

    @Step("Add new user to the phone book")
    public void postNewUser(User newUser){
        RestAssured.baseURI = "http://localhost:8080";

        response = SerenityRest.given().log().body()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/users");
    }

    @Step("Search new user by id")
    public void searchNewUserById(int id) {
        RestAssured.baseURI = "http://localhost:8080";
        response = SerenityRest.given()
                .when()
                .get("/users/{userId}", id);
    }

    @Step("Search is executed succesfully")
    public void isExecutedSuccesfully() {
        response.then().log().body().statusCode(200);
    }
}
