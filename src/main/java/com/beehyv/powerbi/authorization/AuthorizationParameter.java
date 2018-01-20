package com.beehyv.powerbi.authorization;

public class AuthorizationParameter {

    public static final String AUTHORITY = "https://login.microsoftonline.com";
    public static final String ACCESS_TOKEN_URL = AUTHORITY+"/%s/oauth2/token";
    public static final String GRANT_TYPE = "grant_type";
    public static final String RESOURCE = "resource";
    public static final String CLIENT_ID = "client_id";
    public static final String REDIRECT_URI = "redirect_uri";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String CLIENT_SECRET = "client_secret";
    public static final String REFRESH_TOKEN = "refresh_token";
}
