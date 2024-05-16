package br.com.parana.automation.callRest;

import br.com.parana.automation.setupEndpoint.ConfigUrl;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ParanaCalls {

    public ExtractableResponse<Response> getParanaService() {

        return given()
                    .contentType(ContentType.JSON)
                .when()
                    .get(ConfigUrl.urlParanaService())
                .then()
                    .log().body()
                    .extract();
    }

    public ExtractableResponse<Response> postParanaService(File payload) {

        return given()
                    .contentType(ContentType.JSON)
                    .body(payload)
                .when()
                    .post(ConfigUrl.urlParanaService())
                .then()
                    .log().body()
                    .extract();
    }

    public ExtractableResponse<Response> putParanaService(File payload) {

        return given()
                    .contentType(ContentType.JSON)
                    .body(payload)
                .when()
                    .put(ConfigUrl.urlParanaService() + "/2")
                .then()
                    .log().body()
                    .extract();
    }

    public ExtractableResponse<Response> deleteParanaService() {

        return given()
                .contentType(ContentType.JSON)
                .when()
                    .delete(ConfigUrl.urlParanaService() + "/3")
                .then()
                    .log().body()
                    .extract();
    }


}
