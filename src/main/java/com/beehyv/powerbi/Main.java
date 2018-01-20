package com.beehyv.powerbi;

public class Main {

    public static void main(String[] args) {
        PowerBIRestClient client = new PowerBIRestClient();
        client.init();
        client.initGroups();
        client.getGroups().forEach(g -> System.out.println(g));
        client.initDatasetsForAllGroups();
        client.getGroups().forEach(g -> g.getDatasets().forEach(d -> System.out.println(d)));
        client.initDatasourcesForAllDatasetsForAllGroups();
        client.getGroups().forEach(g -> g.getDatasets().forEach(d ->
                d.getDatasources().forEach(ds -> System.out.println(ds))
        ));
        client.initTablesForAllDatasetsForAllGroups();
        //some issues with table initialization as they are null
//        client.getGroups().forEach(g -> g.getDatasets().forEach(d ->
//                d.getTables()==null?System.out.println("null"):{d.getTables().forEach(t -> System.out.println(t==null?"":t))
//        ));
        client.initReportsForAllGroups();
        client.getGroups().forEach(g -> g.getReports().forEach(r -> System.out.println(r)));
        client.initDashboardsForAllGroups();
        client.initTilesForAllDashboardsForAllGroups();
        client.getGroups().forEach(g->g.getDashboards().forEach(d-> System.out.println(d)));
    }
}
