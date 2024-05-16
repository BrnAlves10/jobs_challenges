package br.com.parana.automation.setupEndpoint;

import org.junit.jupiter.api.extension.ExtendWith;

public class ConfigUrl {

    public static String urlParanaService() {
        new GlobalEnv().configurationEndpoint();
        return GlobalEnv.ENDPOINT_URL;
    }
}
