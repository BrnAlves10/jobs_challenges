package testSuites;

import org.junit.jupiter.api.*;
import testCases.ParanaFailure;
import testCases.ParanaSuccess;

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
    @Order(1)
    @DisplayName("GET paranaService")
    public void get_paranaService() throws Exception {
        paranaSuccess.testGETparanaService();
    }

}
