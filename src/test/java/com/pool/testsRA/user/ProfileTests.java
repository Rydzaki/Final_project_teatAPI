package com.pool.testsRA.user;

import com.pool.dto.ResponseDto;
import com.pool.dto.user.UserDto;
import com.pool.testsRA.TestBase;
import io.restassured.http.Cookie;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProfileTests extends TestBase {


    @Test
    public void profileNegativeTest() {
        ResponseDto dto = given()
                .get("/users/profile")
                .then()
                .assertThat().statusCode(401)
                .extract().response().as(ResponseDto.class);

        System.out.println(dto.getMessage());
    }



   @Test
    public void getProfilePositiveTest() {

        UserDto dto = given()
                .cookie(new Cookie.Builder(SESSION_ID, getCookiesForLogin().get(SESSION_ID).getValue()).build()) // Установка сессии из куки
                .when()
                .get("/users/profile")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(UserDto.class);

       // Создание Json с отступами и новыми строками
       printJson(dto);
   }


}