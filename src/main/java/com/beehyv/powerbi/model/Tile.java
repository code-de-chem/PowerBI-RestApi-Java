package com.beehyv.powerbi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tile {
    private String id;
    private String title;
    private String rowSpan;
    private String colSpan;
    private String embedUrl;
    private String embedData;
    private String reportId;
    private String datasetId;

    @JsonProperty("definition")
    private TIleDefinition definition;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRowSpan() {
        return rowSpan;
    }

    public void setRowSpan(String rowSpan) {
        this.rowSpan = rowSpan;
    }

    public String getColSpan() {
        return colSpan;
    }

    public void setColSpan(String colSpan) {
        this.colSpan = colSpan;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    public String getEmbedData() {
        return embedData;
    }

    public void setEmbedData(String embedData) {
        this.embedData = embedData;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    public TIleDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(TIleDefinition definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", rowSpan='" + rowSpan + '\'' +
                ", colSpan='" + colSpan + '\'' +
                ", embedUrl='" + embedUrl + '\'' +
                ", embedData='" + embedData + '\'' +
                ", reportId='" + reportId + '\'' +
                ", datasetId='" + datasetId + '\'' +
                ", definition=" + definition +
                '}';
    }
}
