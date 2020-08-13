package ru.dins.shashkov.tests.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import ru.dins.shashkov.tests.users.Contact;

public class PostNewContactSteps {
    private Response response;

    @Step("Add new contact to the phone book")
    public void addNewContact(Contact newContact) {
        RestAssured.baseURI = "http://localhost:8080";

        response = SerenityRest.given().log().body()
                .contentType("application/json")
                .body(newContact)
                .when()
                .post("users/{userId}/contacts", 1);
    }

    @Step("Post is executed succesfully")
    public void isExecutedSuccesfully(Contact newContact) {
        response.then().log().body().statusCode(201);
    }
}
