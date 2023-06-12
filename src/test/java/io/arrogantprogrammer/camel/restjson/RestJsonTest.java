package io.arrogantprogrammer.camel.restjson;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;


@QuarkusTest @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestJsonTest {

    @Test @Order(1)
    public void testFruits() {

        given()
                .when()
                .get("/fruits")
                .then()
                .statusCode(200)
                .body(
                        "$.size()", is(2),
                        "name", containsInAnyOrder("Apple", "Pineapple"),
                        "description", containsInAnyOrder("Winter fruit", "Tropical fruit")
                );
    }

    @Test @Order(2)
    public void testAddingAFruit() {
        given()
                .body("{\"name\": \"Pear\", \"description\": \"Winter fruit\"}")
                .header("Content-Type", "application/json")
                .when()
                .post("/fruits")
                .then()
                .statusCode(200)
                .body(
                        "$.size()", is(3),
                        "name", containsInAnyOrder("Apple", "Pineapple", "Pear"),
                        "description", containsInAnyOrder("Winter fruit", "Tropical fruit", "Winter fruit"));
    }

    @Test @Order(3)
    public void legumes() {
        given()
                .when().get("/legumes")
                .then()
                .statusCode(200)
                .body("$.size()", is(2),
                        "name", containsInAnyOrder("Carrot", "Zucchini"),
                        "description", containsInAnyOrder("Root vegetable, usually orange", "Summer squash"));
    }
}
