package com.beehyv.powerbi.model;

public class Datasource {
    private String name;
    private String connectionString;
    private String datasourceType;
    private DatasourceConnectionDetail connectionDetails;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getDatasourceType() {
        return datasourceType;
    }

    public void setDatasourceType(String datasourceType) {
        this.datasourceType = datasourceType;
    }

    public DatasourceConnectionDetail getConnectionDetails() {
        return connectionDetails;
    }

    public void setConnectionDetails(DatasourceConnectionDetail connectionDetails) {
        this.connectionDetails = connectionDetails;
    }

    @Override
    public String toString() {
        return "Datasource{" +
                "name='" + name + '\'' +
                ", connectionString='" + connectionString + '\'' +
                ", datasourceType='" + datasourceType + '\'' +
                ", connectionDetails=" + connectionDetails +
                '}';
    }
}
