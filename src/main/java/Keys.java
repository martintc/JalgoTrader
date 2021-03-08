package Jalgo;

public class Keys {
    private String apiKey;
    private String secretKey;
    private String liveEndPoint;
    private String paperEndPoint;

    public Keys (String initApiKey, String initSecretKey, String initLiveEnpoint, String initPaperEndPoint) {
        this.apiKey = initApiKey;
        this.secretKey = initSecretKey;
        this.liveEndPoint = initLiveEnpoint;
        this.paperEndPoint = initPaperEndPoint;
    }

    public String getAPIKey () {
        return apiKey;
    }

    public String getSecretKey () {
        return secretKey;
    }

    public String getLiveEndPoint () {
        return liveEndPoint;
    }

    public String getPaperEndpoint () {
        return paperEndPoint;
    }


}
