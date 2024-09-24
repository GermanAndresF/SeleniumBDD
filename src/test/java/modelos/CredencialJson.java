package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class CredencialJson {
    @JsonProperty("credentials")
    private Map<String, Credencial> mapCredenciales;

    public Map<String, Credencial> getMapCredenciales() {
        return mapCredenciales;
    }
}
