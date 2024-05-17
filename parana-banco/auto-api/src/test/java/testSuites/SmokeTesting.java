package testSuites;

import br.com.parana.automation.utils.TestResultExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import testCases.ParanaFailure;
import testCases.ParanaSuccess;

@ExtendWith(TestResultExtension.class)
@Tag("PARANABANCO")
public class SmokeTesting {

    private ParanaSuccess paranaSuccess;
    private ParanaFailure paranaFailure;

    @BeforeEach
    public void Background() {
        paranaSuccess = new ParanaSuccess();
        paranaFailure = new ParanaFailure();
    }

    @Test
    @DisplayName("GET paranaService-SUCESSO")
    public void get_paranaService() throws Exception {
        paranaSuccess.testGETparanaService();
    }

    @Test
    @DisplayName("POST paranaService-SUCESSO")
    public void post_paranaService() throws Exception {
        paranaSuccess.testPOSTparanaService();
    }

    @Test
    @DisplayName("PUT paranaService-SUCESSO")
    public void put_paranaService() throws Exception {
        paranaSuccess.testPUTparanaService();
    }

    @Test
    @DisplayName("DELETE paranaService-SUCESSO")
    public void delete_paranaService() throws Exception {
        paranaSuccess.testDELETEparanaService();
    }

}
