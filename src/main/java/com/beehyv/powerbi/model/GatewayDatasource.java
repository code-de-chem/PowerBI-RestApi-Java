package com.beehyv.powerbi.model;

public class GatewayDatasource {
    private String id;
    private String gatewayId;
    private String datsourceType;
    private String connectionDetails;
    private String credentialType;
    private String datasourceName;

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

    public String getDatsourceType() {
        return datsourceType;
    }

    public void setDatsourceType(String datsourceType) {
        this.datsourceType = datsourceType;
    }

    public String getConnectionDetails() {
        return connectionDetails;
    }

    public void setConnectionDetails(String connectionDetails) {
        this.connectionDetails = connectionDetails;
    }

    public String getCredentialType() {
        return credentialType;
    }

    public void setCredentialType(String credentialType) {
        this.credentialType = credentialType;
    }

    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
    }
}
