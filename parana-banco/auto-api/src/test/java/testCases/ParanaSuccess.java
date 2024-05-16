package testCases;

import br.com.parana.automation.callRest.ParanaCalls;
import br.com.parana.automation.utils.ActionsBase;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;


public class ParanaSuccess extends ActionsBase {

    ParanaCalls call = new ParanaCalls();

    /**
     * Realiza teste de GET
     */
    public String testGETparanaService() throws Exception {
        try {
            ExtractableResponse<Response> resposta = call.getParanaService();
            int respostaCode = resposta.response().getStatusCode();
            comparaStatusCodeRetornado(200, respostaCode);

        } catch (AssertionError ae) {
            System.out.println("O teste falhou: " + ae.getMessage());
            throw ae;
        }
        return null;
    }


}
