package br.com.parana.automation.callRest;

import br.com.parana.automation.setupEndpoint.ConfigUrl;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
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

}
