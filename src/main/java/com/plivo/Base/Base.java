package com.plivo.Base;

import com.plivo.Utils.ConfigUtil;
import com.plivo.Utils.PlivoConstants;

public class Base {

    private String baseUrl;
    private String baseEndPoint;
    private String numberResource;
    private String messageResource;
    private String pricingResource;
    private String accountResource;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl() {
       String baseUrl = ConfigUtil.getDataFromConfig("base_url");
       if(baseUrl==null)
           baseUrl = PlivoConstants.DEFAULT_URL;
    }

    public String getBaseEndPoint() {
        return baseEndPoint;
    }

    public void setBaseEndPoint(String baseEndPoint) {


        this.baseEndPoint = PlivoConstants.BASE_END_POINT;
    }

    public String getNumberResource() {
        return numberResource;
    }

    public void setNumberResource(String numberResource) {
        this.numberResource = PlivoConstants.;
    }


    public String getPricingResource() {
        return pricingResource;
    }

    public void setPricingResource(String pricingResource) {
        this.pricingResource = pricingResource;
    }




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsernameAndPassword() {
        return usernameAndPassword;
    }

    public void setUsernameAndPassword(String usernameAndPassword) {
        this.usernameAndPassword = usernameAndPassword;
    }

    public String getAuthorizationHeaderValue() {
        return authorizationHeaderValue;
    }

    public void setAuthorizationHeaderValue(String authorizationHeaderValue) {
        this.authorizationHeaderValue = authorizationHeaderValue;
    }

    String username = ConfigUtil.getDataFromConfig("Username");
    String password = ConfigUtil.getDataFromConfig("Password");

    String usernameAndPassword = username + ":" + password;
    public   String authorizationHeaderValue = "Basic " + java.util.Base64.getEncoder().encodeToString( usernameAndPassword.getBytes() );

}
