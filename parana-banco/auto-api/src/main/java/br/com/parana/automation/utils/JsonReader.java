package br.com.parana.automation.utils;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class JsonReader {

    public static Path root = FileSystems.getDefault().getPath("").toAbsolutePath();

    public File getJson(String pathLocal) {
        return new File(pathLocal);
    }

    public File selectPayloadJson(String arquivoJson) {
        String caminhoBasePath = root + "/src/test/resources/payloads/" + arquivoJson;
        return getJson(caminhoBasePath);
    }

    public String selectSchemaJson(String arquivoJson) {
        return root + "/src/test/resources/schemas/" + arquivoJson;

    }

}
