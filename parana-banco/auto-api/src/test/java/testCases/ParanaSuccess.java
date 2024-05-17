package testCases;

import br.com.parana.automation.callRest.ParanaCalls;
import br.com.parana.automation.utils.ActionsBase;
import br.com.parana.automation.utils.JsonReader;
import br.com.parana.automation.utils.TestResultExtension;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestResultExtension.class)
public class ParanaSuccess extends ActionsBase {

    ParanaCalls call = new ParanaCalls();
    JsonReader jsonReader = new JsonReader();
    TestResultExtension report = new TestResultExtension();

    /**
     * SUCESSO AO Realiza teste de GET
     */
    public String testGETparanaService(){
        try {
            ExtractableResponse<Response> resposta = call.getParanaService();
            int respostaCode = resposta.response().getStatusCode();
            report.registroRespostaBodyRelatorio(resposta);
            comparaStatusCodeRetornado(200, respostaCode);

        } catch (AssertionError ae) {
            System.out.println("O teste falhou: " + ae.getMessage());
            throw ae;
        }
        return null;
    }

    /**
     * SUCESSO AO Realiza teste de POST
     */
    public String testPOSTparanaService() {
        try {
            ExtractableResponse<Response> resposta = call.postParanaService(jsonReader.selectPayloadJson("payloadPOST.json"));
            int respostaCode = resposta.response().getStatusCode();
            report.registroRespostaBodyRelatorio(resposta);
            comparaStatusCodeRetornado(201, respostaCode);

        } catch (AssertionError ae) {
            System.out.println("O teste falhou: " + ae.getMessage());
            throw ae;
        }
        return null;
    }

    /**
     * SUCESSO AO Realiza teste de PUT
     */
    public String testPUTparanaService() {
        try {
            ExtractableResponse<Response> resposta = call.putParanaService(jsonReader.selectPayloadJson("payloadPUT.json"));
            int respostaCode = resposta.response().getStatusCode();
            report.registroRespostaBodyRelatorio(resposta);
            comparaStatusCodeRetornado(200, respostaCode);

        } catch (AssertionError ae) {
            System.out.println("O teste falhou: " + ae.getMessage());
            throw ae;
        }
        return null;
    }

    /**
     * SUCESSO AO Realiza teste de DELETE
     */
    public String testDELETEparanaService() {
        try {
            ExtractableResponse<Response> resposta = call.deleteParanaService();
            int respostaCode = resposta.response().getStatusCode();
            report.registroRespostaBodyRelatorio(resposta);
            comparaStatusCodeRetornado(200, respostaCode);

        } catch (AssertionError ae) {
            System.out.println("O teste falhou: " + ae.getMessage());
            throw ae;
        }
        return null;
    }



}
