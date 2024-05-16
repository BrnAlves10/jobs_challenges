package br.com.parana.automation.setupEndpoint;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

public class GlobalEnv extends ConfigUrl {

    private Properties properties;
    public static Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
    public static String ENDPOINT_URL;

    public void configurationEndpoint() {
        properties = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(root + "/src/main/java/br/com/parana/automation/setupEndpoint/globalEnv.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ENDPOINT_URL = properties.getProperty("hostUrl");

    }

}
