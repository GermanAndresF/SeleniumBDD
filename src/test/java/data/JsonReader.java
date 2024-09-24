package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import modelos.CredencialJson;
import utilities.Logs;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    private static final String credencialesPath =
            "src/test/resources/data/credenciales.json";

    public static CredencialJson obtenerMapCredenciales() {
        final var objectMapper = new ObjectMapper();

        try {
            return objectMapper
                    .readValue(new File(credencialesPath), CredencialJson.class);
        } catch (IOException ioException) {
            Logs.error("Error al leer json de credenciales: %s",
                    ioException.getLocalizedMessage());
            throw new RuntimeException(ioException.getLocalizedMessage());
        }
    }
}
