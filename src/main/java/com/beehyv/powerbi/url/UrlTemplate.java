package com.beehyv.powerbi.url;

public class UrlTemplate {

    private UrlTemplate() {
    }
    public static final String API_URL = "https://api.powerbi.com";
    public static final String VERSION_1 = "v1.0";
    public static final String VERSION_BETA = "beta";
    public static final String CURRENT_VERSION = VERSION_1;
    public static final String BASE_URL = API_URL+"/"+CURRENT_VERSION+"/myorg/";
    public static final String GROUPS = BASE_URL+"groups/";
    public static final String DATASETS = BASE_URL+"datasets/";
    public static final String GROUP_DATASETS = GROUPS+"%s/datasets/";
    public static final String DATASET_DATASOURCES = DATASETS+"datasources/";
    public static final String GROUP_DATASET_DATASOURCES = GROUP_DATASETS+"%s/datasources/";
    public static final String DATASET_TABLES = DATASETS+"tables/";
    public static final String GROUP_DATASET_TABLES = GROUP_DATASETS+"%s/tables/";
    public static final String REPORTS = BASE_URL+"reports/";
    public static final String GROUP_REPORTS = GROUPS+"%s/reports/";
    public static final String DASHBOARDS = BASE_URL+"dashboards/";
    public static final String GROUP_DASHBOARDS = GROUPS+"%s/dashboards/";
    public static final String DASHBOARD_TILES = DASHBOARDS+"tiles/";
    public static final String GROUP_DASHBOARD_TILES = GROUP_DASHBOARDS+"%s/tiles/";




}
