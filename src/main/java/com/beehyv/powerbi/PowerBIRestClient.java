package com.beehyv.powerbi;

import com.beehyv.powerbi.authorization.AppCredential;
import com.beehyv.powerbi.authorization.AuthorizationContext;
import com.beehyv.powerbi.authorization.ClientCredential;
import com.beehyv.powerbi.model.*;
import com.beehyv.powerbi.url.UrlTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PowerBIRestClient {

    private File tokenFile = new File("token.sau");
    private AuthorizationContext authorizationContext = null;
    private HttpClient httpclient = HttpClients.createDefault();
    private HttpGet httpGet;


    private List<Group> groups;


    public PowerBIRestClient() {

    }

    public void init() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(tokenFile));
            authorizationContext = (AuthorizationContext) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (authorizationContext == null)
            authorizationContext = getAuthorizationContext();


        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tokenFile));
            out.writeObject(authorizationContext);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initGroups() {
        groups = getAllGroups(authorizationContext.getAccessToken());
    }

    public void initDatasetsForAllGroups() {
        groups.forEach(g -> g.setDatasets(getAllDatasetsOfGroup(authorizationContext.getAccessToken(), g.getId())));
    }

    public void initDatasourcesForAllDatasetsForAllGroups() {
        groups.forEach(g -> g.getDatasets().forEach(d ->
                d.setDatasources(getAllDatasourcesOfGroupOfDataset(authorizationContext.getAccessToken(), g.getId(), d.getId()))
        ));
    }

    public void initTablesForAllDatasetsForAllGroups() {
        groups.forEach(g -> g.getDatasets().forEach(d ->
                d.setTables(getAllTablesOfGroupOfDataset(authorizationContext.getAccessToken(), g.getId(), d.getId()))
        ));
    }

    public void initReportsForAllGroups() {
        groups.forEach(g -> g.setReports(getAllReportsOfGroup(authorizationContext.getAccessToken(), g.getId())));
    }

    public void initDashboardsForAllGroups() {
        groups.forEach(g -> g.setDashboards(getAllDashboardsOfGroup(authorizationContext.getAccessToken(), g.getId())));
    }

    public void initTilesForAllDashboardsForAllGroups() {
        groups.forEach(g -> g.getDashboards().forEach(d ->
                d.setTiles(getAllTilesOfGroupOfDashboard(authorizationContext.getAccessToken(), g.getId(), d.getId()))
        ));
    }

    private List<Group> getAllGroups(String token) {
        httpGet = new HttpGet(UrlTemplate.GROUPS);
        return processGetResponseHelper(token, Group.class);
    }

    private List<Dataset> getAllDatasetsOfGroup(String token, String group) {
        httpGet = new HttpGet(String.format(UrlTemplate.GROUP_DATASETS, group));
        return processGetResponseHelper(token, Dataset.class);
    }

    private List<Datasource> getAllDatasourcesOfGroupOfDataset(String token, String group, String dataset) {
        httpGet = new HttpGet(String.format(UrlTemplate.GROUP_DATASET_DATASOURCES, group, dataset));
        return processGetResponseHelper(token, Datasource.class);
    }

    private List<Table> getAllTablesOfGroupOfDataset(String token, String group, String dataset) {
        httpGet = new HttpGet(String.format(UrlTemplate.GROUP_DATASET_TABLES, group, dataset));
        return processGetResponseHelper(token, Table.class);
    }

    private List<Report> getAllReportsOfGroup(String token, String group) {
        httpGet = new HttpGet(String.format(UrlTemplate.GROUP_REPORTS, group));
        return processGetResponseHelper(token, Report.class);
    }

    private List<Dashboard> getAllDashboardsOfGroup(String token, String group) {
        httpGet = new HttpGet(String.format(UrlTemplate.GROUP_DASHBOARDS, group));
        return processGetResponseHelper(token, Dashboard.class);
    }

    private List<Tile> getAllTilesOfGroupOfDashboard(String token, String group, String dashboard) {
        httpGet = new HttpGet(String.format(UrlTemplate.GROUP_DASHBOARD_TILES, group, dashboard));
        return processGetResponseHelper(token, Tile.class);
    }

    private <T> List<T> processGetResponseHelper(String token, Class<T> tClass) {
        try {
            httpGet.setHeader("Authorization", "Bearer " + token);

            HttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String res = null;

            res = EntityUtils.toString(entity);


            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readValue(res, JsonNode.class);
            if(jsonNode.get("value")!=null)
                return objectMapper.readValue(jsonNode.get("value").toString(), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass));
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return null;
    }


    //getters and setters


    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }


    public static String username = "";
    public static String password = "";
    public static String client_id = "";
    public static String client_secret = "";
    public static String tenant = "";
    public static String redirectURI = "http://localhost:8082/adal4jsample/";
    public static String resourceURI = "https://analysis.windows.net/powerbi/api";
//    public static String resourceURI = "https://management.core.windows.net/";


    public static ClientCredential getClientCredential() {
        return new ClientCredential(username, password);
    }

    public static AppCredential getAppCredential() {
        return new AppCredential(client_id, client_secret);
    }

    public static AuthorizationContext getAuthorizationContext() {
        return new AuthorizationContext(getAppCredential(), getClientCredential(), tenant, resourceURI, redirectURI);
    }
}
