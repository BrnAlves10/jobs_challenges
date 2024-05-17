package br.com.parana.automation.testSuites;

import br.com.parana.automation.testCases.ParanaSuccess;
import br.com.parana.automation.utils.TestResultExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import br.com.parana.automation.testCases.ParanaFailure;

@Tag("smoke")
@ExtendWith(TestResultExtension.class)
public class SmokeTesting {

    private ParanaSuccess paranaSuccess;
    private ParanaFailure paranaFailure;

    @BeforeEach
    public void Background() {
        paranaSuccess = new ParanaSuccess();
        paranaFailure = new ParanaFailure();
    }

    @Nested
    @Order(1)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Validacao_Sucessos{

        @Test
        @Order(1)
        @DisplayName("Valida SUCESSO na chamada GET ParanaBanco")
        public void get_paranaService() {
            paranaSuccess.valida_sucesso_GET_paranaBanco();
        }

        @Test
        @Order(2)
        @DisplayName("Valida SUCESSO na chamada POST ParanaBanco")
        public void post_paranaService(){
            paranaSuccess.valida_sucesso_POST_paranaBanco();
        }

        @Test
        @Order(3)
        @DisplayName("Valida SUCESSO na chamada PUT ParanaBanco")
        public void put_paranaService(){
            paranaSuccess.valida_sucesso_PUT_paranaBanco();
        }

        @Test
        @Order(4)
        @DisplayName("Valida SUCESSO na chamada DELETE ParanaBanco")
        public void delete_paranaService(){
            paranaSuccess.valida_sucesso_DELETE_paranaBanco();
        }

        @Test
        @Order(4)
        @DisplayName("Valida SUCESSO na chamada SCHEMA ParanaBanco")
        public void schema_paranaService(){
            paranaSuccess.validacao_SCHEMA();
        }

    }


    @Nested
    @Order(2)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Validacao_Falhas{

        @Test
        @Order(1)
        @DisplayName("Valida FALHA na chamada GET com Endpoint incorreto")
        public void get_falha_paranaService() {
            paranaFailure.valida_falha_GET_com_url_incorreta_paranaBanco();
        }
    }

}
