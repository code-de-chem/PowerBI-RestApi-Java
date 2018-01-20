package com.beehyv.powerbi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Dataset {
    private String id;
    private String name;
    private String configuredBy;
    @JsonProperty("addRowsAPIEnabled")
    private boolean addRowsAPIEnabled;
    @JsonProperty("isRefreshable")
    private boolean isRefreshable;
    @JsonProperty("isEffectiveIdentityRequired")
    private boolean isEffectiveIdentityRequired;
    @JsonProperty("isEffectiveIdentityRolesRequired")
    private boolean isEffectiveIdentityRolesRequired;
    @JsonProperty("isOnPremGatewayRequired")
    private boolean isOnPremGatewayRequired;

    //additional fields
    private List<Table> tables;
    private List<Datasource> datasources;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfiguredBy() {
        return configuredBy;
    }

    public void setConfiguredBy(String configuredBy) {
        this.configuredBy = configuredBy;
    }

    public boolean isAddRowsAPIEnabled() {
        return addRowsAPIEnabled;
    }

    public void setAddRowsAPIEnabled(boolean addRowsAPIEnabled) {
        this.addRowsAPIEnabled = addRowsAPIEnabled;
    }

    public boolean isRefreshable() {
        return isRefreshable;
    }

    public void setRefreshable(boolean refreshable) {
        isRefreshable = refreshable;
    }

    public boolean isEffectiveIdentityRequired() {
        return isEffectiveIdentityRequired;
    }

    public void setEffectiveIdentityRequired(boolean effectiveIdentityRequired) {
        isEffectiveIdentityRequired = effectiveIdentityRequired;
    }

    public boolean isEffectiveIdentityRolesRequired() {
        return isEffectiveIdentityRolesRequired;
    }

    public void setEffectiveIdentityRolesRequired(boolean effectiveIdentityRolesRequired) {
        isEffectiveIdentityRolesRequired = effectiveIdentityRolesRequired;
    }

    public boolean isOnPremGatewayRequired() {
        return isOnPremGatewayRequired;
    }

    public void setOnPremGatewayRequired(boolean onPremGatewayRequired) {
        isOnPremGatewayRequired = onPremGatewayRequired;
    }


    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Datasource> getDatasources() {
        return datasources;
    }

    public void setDatasources(List<Datasource> datasources) {
        this.datasources = datasources;
    }


    @Override
    public String toString() {
        return "Dataset{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", configuredBy='" + configuredBy + '\'' +
                ", addRowsAPIEnabled=" + addRowsAPIEnabled +
                ", isRefreshable=" + isRefreshable +
                ", isEffectiveIdentityRequired=" + isEffectiveIdentityRequired +
                ", isEffectiveIdentityRolesRequired=" + isEffectiveIdentityRolesRequired +
                ", isOnPremGatewayRequired=" + isOnPremGatewayRequired +
                '}';
    }
}
