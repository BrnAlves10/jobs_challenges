package br.com.parana.automation.testCases;

import br.com.parana.automation.setupEndpoint.ConfigUrl;
import br.com.parana.automation.utils.ActionsBase;
import br.com.parana.automation.utils.JsonReader;
import br.com.parana.automation.utils.TestResultExtension;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.Matchers.equalTo;

@Tag("paranaSucessos")
@ExtendWith(TestResultExtension.class)
public class ParanaSuccess extends ActionsBase {

    JsonReader json = new JsonReader();
    TestResultExtension report = new TestResultExtension();


    /**
     * SUCESSO AO Realiza teste de GET
     */
    @Test
    public void valida_sucesso_GET_paranaBanco(){

        try {

            ExtractableResponse<Response> resposta =
                    given()
                        .contentType(ContentType.JSON)
                    .when()
                        .get(ConfigUrl.urlParanaService())
                    .then()
                        .assertThat().statusCode(200)
                        .log().ifStatusCodeMatches(equalTo(200))
                    .extract();
            report.registroRespostaBodyRelatorio(resposta);

        } catch (AssertionError ae) {
            System.out.println("O teste falhou: " + ae.getMessage());
            throw ae;
        }

    }

    /**
     * SUCESSO AO Realiza teste de POST
     */
    @Test
    public void valida_sucesso_POST_paranaBanco() {

        try {

            ExtractableResponse<Response> resposta =
                    given()
                        .contentType(ContentType.JSON)
                        .body(json.selectPayloadJson("payloadPOST.json"))
                    .when()
                        .post(ConfigUrl.urlParanaService())
                    .then()
                        .assertThat().statusCode(201)
                        .log().ifStatusCodeMatches(equalTo(201))
                    .extract();

            report.registroRespostaBodyRelatorio(resposta);

        } catch (AssertionError ae) {
            System.out.println("O teste falhou: " + ae.getMessage());
            throw ae;
        }
    }

    /**
     * SUCESSO AO Realiza teste de PUT
     */
    @Test
    public void valida_sucesso_PUT_paranaBanco() {

        try {

            ExtractableResponse<Response> resposta =
                    given()
                        .contentType(ContentType.JSON)
                        .body(json.selectPayloadJson("payloadPUT.json"))
                    .when()
                        .put(ConfigUrl.urlParanaService() + "/2")
                    .then()
                        .assertThat().statusCode(200)
                        .log().ifStatusCodeMatches(equalTo(200))
                    .extract();

            report.registroRespostaBodyRelatorio(resposta);

        } catch (AssertionError ae) {
            System.out.println("O teste falhou: " + ae.getMessage());
            throw ae;
        }

    }

    /**
     * SUCESSO AO Realiza teste de DELETE
     */
    @Test
    public void valida_sucesso_DELETE_paranaBanco() {

        try {
            ExtractableResponse<Response> resposta =
                    given()
                        .contentType(ContentType.JSON)
                    .when()
                        .delete(ConfigUrl.urlParanaService() + "/3")
                    .then()
                        .assertThat().statusCode(200)
                        .log().ifStatusCodeMatches(equalTo(200))
                    .extract();

            report.registroRespostaBodyRelatorio(resposta);

        } catch (AssertionError ae) {
            System.out.println("O teste falhou: " + ae.getMessage());
            throw ae;
        }

    }

    /**
     * SUCESSO Validacao SCHEMA
     */
    @Test
    public void validacao_SCHEMA() {

        try {
            ExtractableResponse<Response> resposta =
                    given()
                        .contentType(ContentType.JSON)
                    .when()
                        .get(ConfigUrl.urlParanaService() + "/2")
                    .then()
                        .assertThat()
                        .body(matchesJsonSchemaInClasspath("schemas/userSchema.json"))
                        .statusCode(200)
                        .body("name", equalTo("Ervin Howell"))
                        .body("username", equalTo("Antonette"))
                        .body("email", equalTo("Shanna@melissa.tv"))
                        .body("address.city", equalTo("Wisokyburgh"))
                        .log().ifStatusCodeMatches(equalTo(200))
                    .extract();

            report.registroRespostaBodyRelatorio(resposta);

        } catch (AssertionError ae) {
            System.out.println("O teste falhou: " + ae.getMessage());
            throw ae;
        }

    }

}
