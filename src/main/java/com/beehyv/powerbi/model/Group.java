package com.beehyv.powerbi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Group {

    private String id;
    private String name;
    @JsonProperty("isReadOnly")
    private boolean isReadOnly;
    @JsonProperty("isOnDedicatedCapacity")
    private boolean isOnDedicatedCapacity;

    //additional fields
    @JsonIgnore
    private List<Dataset> datasets;
    private List<Report> reports;
    private List<Dashboard> dashboards;
    private List<Import> imports;

    public Group() {
    }

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

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(boolean readOnly) {
        isReadOnly = readOnly;
    }

    public boolean isOnDedicatedCapacity() {
        return isOnDedicatedCapacity;
    }

    public void setOnDedicatedCapacity(boolean onDedicatedCapacity) {
        isOnDedicatedCapacity = onDedicatedCapacity;
    }

    public List<Dataset> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<Dataset> datasets) {
        this.datasets = datasets;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public List<Dashboard> getDashboards() {
        return dashboards;
    }

    public void setDashboards(List<Dashboard> dashboards) {
        this.dashboards = dashboards;
    }

    public List<Import> getImports() {
        return imports;
    }

    public void setImports(List<Import> imports) {
        this.imports = imports;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isReadOnly=" + isReadOnly +
                ", isOnDedicatedCapacity=" + isOnDedicatedCapacity +
                '}';
    }
}
