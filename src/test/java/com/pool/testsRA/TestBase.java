package com.pool.testsRA;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pool.dto.NewUserDto;
import com.pool.dto.UserDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public class TestBase {

    public static final String EMAIL = "ushakov_test@mail.com";
    public static final String EMAIL_INVALID = "@mail.com";
    public static final String PASSWORD = "Pass12345!";
    public static final String PASSWORD_INVALID = "Pass123455";
    public static final String MESSAGE = "Login successful";
    public static final String SESSION_ID = "JSESSIONID";


    String n = "1";
    NewUserDto register = NewUserDto.builder()
            .firstName("Bruce")
            .lastName("Wayne")
            .email("autest" + n + "@mail.com")
            .phoneNumber("+11234567890")
            .password("Pass12345!")
            .build();




    @BeforeMethod
    public void init() {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/api";
    }

    //Получаю идентификатор сессии
    public static Cookies getCookiesForLogin() {
        return given()
                .contentType(ContentType.URLENC)
                .formParam("username", EMAIL)
                .formParam("password", PASSWORD)
                .when()
                .post("/login")
                .then()
                .extract().response().detailedCookies();

    }


    //Печать в красивом формате JSON
    protected static void printJson(Object dto) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonResponse = gson.toJson(dto);

        // Вывод JSON-ответа с отступами и новыми строками
        System.out.println(jsonResponse);
    }


}
