package com.dursuneryilmaz.userserviceapitest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // run test method by order
public class UsersWebServiceEndpointTest {
    private final String CONTEXT_PATH = "/mobile-app-ws";
    private final String EMAIL_ADDRESS = "dursun1147@gmail.com";
    private final String PASSWORD = "test123";
    private final String JSON = "application/json";
    private final int HTTP_SUCCESS = 200;
    private final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJPVEF5RUI1U0lZRk02T3lONXhLTmhSdHR1MHNqSXNOTiIsImV4cCI6MTYwODY1MzkxN30.4qrCtkTmDYFOMNUuWdTFsF3-TxRRI1oaBBG79tdC8UJ9YZg-fK0eiC5oZlcxk1Nk5gjI7fyPurhSgznqMItoQQ";
    private final String USER_ID = "FvU1cRBL2Okj8lmw0ONOJlicuAsWfjud";
    private static String authorizationHeader;
    private static String userId;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    @Order(1)
    void testUserLogin() {
        Map<String, String> loginDetails = new HashMap<>();
        loginDetails.put("email", EMAIL_ADDRESS);
        loginDetails.put("password", PASSWORD);

        Response response = given()
                .contentType(JSON)
                .accept(JSON)
                .body(loginDetails)
                .when()
                .post(CONTEXT_PATH + "/users/login")
                .andReturn()
                .then()
                .statusCode(HTTP_SUCCESS)
                .extract()
                .response();

        authorizationHeader = response.header("Authorization");
        userId = response.header("UserId");
        assertNotNull(authorizationHeader);
        assertNotNull(userId);
        assertTrue(userId.length() == 32);
    }

    @Test
    @Order(2)
    void testGetUserDetails() {
        Response response = given()
                .header("Authorization", authorizationHeader)
                .pathParam("userId", USER_ID)
                .contentType(JSON)
                .accept(JSON)
                .when()
                .get(CONTEXT_PATH + "/users/{userId}")
                .andReturn()
                .then()
                .statusCode(HTTP_SUCCESS)
                .extract()
                .response();

        String userId = response.jsonPath().getString("userId");
        String emailAddress = response.jsonPath().getString("email");
        assertNotNull(userId);
        assertNotNull(emailAddress);
        assertEquals(emailAddress, EMAIL_ADDRESS);

        List<Map<String, String>> addresses = response.jsonPath().getList("addresses");
        assertTrue(addresses.size() == 2);

        String addressId = addresses.get(0).get("addressId");
        assertNotNull(addressId);
        assertTrue(addressId.length() == 32);

    }

    // disabled because there need to be token which has not been verified yet
    @Test
    @Disabled
    void testVerifyEmail() {
        Response response = given()
                .contentType(JSON)
                .accept(JSON)
                .queryParam("token", TOKEN)
                .when()
                .get(CONTEXT_PATH + "/users/email-verification")
                .andReturn()
                .then()
                .statusCode(HTTP_SUCCESS)
                .extract()
                .response();

        String bodyString = response.body().asString();
        try {
            JSONObject responseBodyJson = new JSONObject(bodyString);

            String operationName = responseBodyJson.getString("operationName");
            assertNotNull(operationName);
            assertEquals(operationName, "VERIFY_EMAIL");

            String operationStatus = responseBodyJson.getString("operationStatus");
            assertNotNull(operationStatus);
            assertEquals(operationStatus, "SUCCESS");

        } catch (JSONException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(3)
    void testUpdateUserDetails() {
        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("firstName", "Dursun Updated");
        userDetails.put("lastName", "Eryılmaz");

        Response response = given()
                .contentType(JSON)
                .accept(JSON)
                .header("Authorization", authorizationHeader)
                .pathParam("userId", USER_ID)
                .body(userDetails)
                .when()
                .put(CONTEXT_PATH + "/users/{userId}")
                .then()
                .statusCode(HTTP_SUCCESS)
                .contentType(JSON)
                .extract()
                .response();

        String firstName = response.jsonPath().getString("firstName");
        String lastName = response.jsonPath().getString("lastName");
        assertNotNull(firstName);
        assertNotNull(lastName);
        assertEquals(firstName, "Dursun Updated");

        List<Map<String, String>> addresses = response.jsonPath().getList("addresses");
        assertTrue(addresses.size() == 2);
    }
}
