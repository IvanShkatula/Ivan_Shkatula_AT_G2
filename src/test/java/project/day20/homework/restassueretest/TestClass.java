package project.day20.homework.restassueretest;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import project.day20.homework.objects.Search;

public class TestClass {

    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("http://178.124.206.46:8001/app/ws/")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .build();

    @Test
    public void searchUserByShortName() {
        Search search = new Search("a", false);

        boolean userShortname = RestAssured
                .given()
                .spec(requestSpecification)
                .body(search)
                .when()
                .post()
                .then()
                .extract().body().equals("Alberto");
               // .extract().body().asString();
        System.out.println(userShortname);
    }

    @Test
    public void example() {
        Search search = new Search("", false);

        String userShortname = RestAssured
                .given()
                .spec(requestSpecification)
                .body(search)
                .when()
                .post()
                .then()
                .extract().body().asString();
        System.out.println(userShortname);
    }
}
