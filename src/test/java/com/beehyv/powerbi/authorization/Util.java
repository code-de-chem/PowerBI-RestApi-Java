package com.beehyv.powerbi.authorization;

public class Util {

    public static String username = "";
    public static String password = "";
    public static String client_id = "";
    public static String client_secret = "";
    public static String tenant = "";
    public static String resourceURI = "https://analysis.windows.net/powerbi/api";
    public static String redirectURI = "http://localhost:8082/adal4jsample/";


    public static ClientCredential getClientCredential(){
        return new ClientCredential(username,password);
    }

    public static AppCredential getAppCredential(){
        return new AppCredential(client_id,client_secret);
    }

    public static AuthorizationContext getAuthorizationContext(){
        return new AuthorizationContext(getAppCredential(), getClientCredential(), tenant, resourceURI, redirectURI);
    }
}
