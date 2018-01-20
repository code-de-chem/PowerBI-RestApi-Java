package com.beehyv.powerbi.model;

public class Gateway {
    private String id;
    private String gatewayId;
    private String name;
    private String type;
    private GatewayPublicKey publicKey;
    private String gatewayAnnotation;
    private String gatewayStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GatewayPublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(GatewayPublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public String getGatewayAnnotation() {
        return gatewayAnnotation;
    }

    public void setGatewayAnnotation(String gatewayAnnotation) {
        this.gatewayAnnotation = gatewayAnnotation;
    }

    public String getGatewayStatus() {
        return gatewayStatus;
    }

    public void setGatewayStatus(String gatewayStatus) {
        this.gatewayStatus = gatewayStatus;
    }
}
