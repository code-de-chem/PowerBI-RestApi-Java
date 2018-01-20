package com.beehyv.powerbi.authorization;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthorizationContext implements Serializable {

    private AppCredential appCredential;
    private ClientCredential clientCredential;
    private String tenant;
    private String resourceURI;
    private String redirectURI;
    private String refreshToken = null;

    public AuthorizationContext(AppCredential appCredential, ClientCredential clientCredential, String tenant, String resourceURI, String redirectURI) {
        this.appCredential = appCredential;
        this.clientCredential = clientCredential;
        this.tenant = tenant;
        this.resourceURI = resourceURI;
        this.redirectURI = redirectURI;
    }

    public String getAccessToken(){
        if(null == refreshToken){
            return getAccessTokenFromPassword("password");
        }else{
            return getAccessTokenFromRefreshToken("refresh_token");
        }
    }

    private String getAccessTokenFromPassword(String grantType) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair(AuthorizationParameter.GRANT_TYPE, grantType));
        params.add(new BasicNameValuePair(AuthorizationParameter.USERNAME, clientCredential.getUsername()));
        params.add(new BasicNameValuePair(AuthorizationParameter.PASSWORD, clientCredential.getPassword()));
        params.add(new BasicNameValuePair(AuthorizationParameter.REDIRECT_URI, redirectURI));
        return getAccessTokenHandler(params);
    }

    private String getAccessTokenFromRefreshToken(String grantType) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair(AuthorizationParameter.REFRESH_TOKEN, refreshToken));
        params.add(new BasicNameValuePair(AuthorizationParameter.GRANT_TYPE, grantType));
        return getAccessTokenHandler(params);
    }

    private String getAccessTokenHandler(List<NameValuePair> params) {
        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(String.format(AuthorizationParameter.ACCESS_TOKEN_URL, tenant));
            params.add(new BasicNameValuePair(AuthorizationParameter.RESOURCE, resourceURI));
            params.add(new BasicNameValuePair(AuthorizationParameter.CLIENT_ID, appCredential.getClientId()));
            params.add(new BasicNameValuePair(AuthorizationParameter.CLIENT_SECRET, appCredential.getClientSecret()));

            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            StringBuilder sb = new StringBuilder();

            BufferedReader rd = new BufferedReader(new InputStreamReader(entity.getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readValue(sb.toString(), JsonNode.class);
            this.refreshToken = jsonNode.get("refresh_token").asText();
            return jsonNode.get("access_token").asText();

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AuthorizationContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AuthorizationContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AuthorizationContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
