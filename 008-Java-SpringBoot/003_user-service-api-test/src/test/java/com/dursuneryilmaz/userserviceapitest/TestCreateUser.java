package com.dursuneryilmaz.userserviceapitest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestCreateUser {
    private final String CONTEXT_PATH = "/mobile-app-ws";

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    void testCreateUser() {
        // provide java object which will converted json object by restassured
        // list of hash maps for user addresses
        List<Map<String, Object>> userAddresses = new ArrayList<>();

        Map<String, Object> shippingAddress = new HashMap<>();
        shippingAddress.put("city", "Kocaeli");
        shippingAddress.put("country", "Turkey");
        shippingAddress.put("streetName", "123 Street name");
        shippingAddress.put("postalCode", "123456");
        shippingAddress.put("type", "shipping");

        Map<String, Object> billingAddress = new HashMap<>();
        billingAddress.put("city", "Kocaeli");
        billingAddress.put("country", "Turkey");
        billingAddress.put("streetName", "123 Street name");
        billingAddress.put("postalCode", "123456");
        billingAddress.put("type", "billing");

        userAddresses.add(shippingAddress);
        userAddresses.add(billingAddress);

        // a has map for userDetails which includes user properties and addresses
        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("firstName", "Dursun");
        userDetails.put("lastName", "Eryılmaz");
        userDetails.put("email", "drsner3@gmail.com");
        userDetails.put("password", "123");
        userDetails.put("addresses", userAddresses);


        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .body(userDetails)
                .when()
                .post(CONTEXT_PATH + "/users")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract()
                .response();
        // check userId is not null which must be created by rest service
        String userId = response.jsonPath().getString("userId");
        assertNotNull(userId);
        assertTrue(userId.length() == 32);

        // check user addresses id's
        String bodyString = response.body().asString();
        try {
            JSONObject responseBodyJson = new JSONObject(bodyString);
            JSONArray addresses = responseBodyJson.getJSONArray("addresses");
            assertNotNull(addresses);
            // provided one address
            assertTrue(addresses.length() == 2);
            // get an address and check its id
            String addressId = addresses.getJSONObject(0).getString("addressId");
            assertNotNull(addressId);
            assertTrue(addressId.length() == 32);


        } catch (JSONException e) {
            fail(e.getMessage());
        }

    }
}
