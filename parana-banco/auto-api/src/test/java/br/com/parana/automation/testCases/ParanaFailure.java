package br.com.parana.automation.testCases;

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


@Tag("ParanaFalha")
@ExtendWith(TestResultExtension.class)
public class ParanaFailure extends ActionsBase {

    JsonReader json = new JsonReader();
    TestResultExtension report = new TestResultExtension();


    /**
     * FALHA ao Realiza teste de GET com parametros de endpoits incorretas
     */
    @Test
    public void valida_falha_GET_com_url_incorreta_paranaBanco(){

        try {

            ExtractableResponse<Response> resposta =
                    given()
                                .contentType(ContentType.JSON)
                            .when()
                                .get("https://jsonplaceholder.typicode.com/ERRADA")
                            .then()
                                .assertThat()
                                    .statusCode(404)
                                .log().ifStatusCodeIsEqualTo(404)
                            .extract();
            report.registroRespostaBodyRelatorio(resposta);

        } catch (AssertionError ae) {
            System.out.println("O teste falhou: " + ae.getMessage());
            throw ae;
        }

    }

}
