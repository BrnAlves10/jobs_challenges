package br.com.parana.automation.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ActionsBase {

    public void comparaStatusCodeRetornado(int codeEsperado, int resposta) {
        assertEquals(codeEsperado, resposta);
    }


}
