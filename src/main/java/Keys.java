package Jalgo;

public class Keys {
    private String apiKey;
    private String secretKey;

    public Keys (String initApiKey, String initSecretKey) {
        this.apiKey = initApiKey;
        this.secretKey = initSecretKey;
    }

    public String getAPIKey () {
        return apiKey;
    }

    public String getSecretKey () {
        return secretKey;
    }
}
