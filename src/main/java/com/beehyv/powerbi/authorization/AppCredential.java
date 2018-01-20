package com.beehyv.powerbi.authorization;

import java.io.Serializable;

public class AppCredential implements Serializable {
    private String clientId;
    private String clientSecret;

    public AppCredential() {
    }

    public AppCredential(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


}
