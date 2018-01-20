package com.beehyv.powerbi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Report {
    private String id;
    private String name;
    private String webUrl;
    private String embedUrl;
    private String datasetId;
    @JsonProperty("isOriginalPbixReport")
    private boolean isOriginalPbixReport;
    @JsonProperty("isOwnedByMe")
    private boolean isOwnedByMe;
    private String modelId;

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

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    public boolean isOriginalPbixReport() {
        return isOriginalPbixReport;
    }

    public void setOriginalPbixReport(boolean originalPbixReport) {
        isOriginalPbixReport = originalPbixReport;
    }

    public boolean isOwnedByMe() {
        return isOwnedByMe;
    }

    public void setOwnedByMe(boolean ownedByMe) {
        isOwnedByMe = ownedByMe;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", embedUrl='" + embedUrl + '\'' +
                ", datasetId='" + datasetId + '\'' +
                ", isOriginalPbixReport=" + isOriginalPbixReport +
                ", isOwnedByMe=" + isOwnedByMe +
                ", modelId='" + modelId + '\'' +
                '}';
    }
}
