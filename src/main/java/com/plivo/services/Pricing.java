package com.plivo.services;

import com.jayway.restassured.response.Response;
import com.plivo.Base.Base;
import com.plivo.Utils.ConfigUtil;
import com.plivo.Utils.PlivoConstants;
import com.plivo.helpers.ApiHelpers;
import com.plivo.models.responsemodels.PricingDAO;

import java.util.HashMap;

public class Pricing extends Base{


    ApiHelpers restApiCall = new ApiHelpers();


    public Response getPricingData( ){

        String url = ConfigUtil.getDataFromConfig("base_url") + PlivoConstants.PRICING;

        HashMap<String, Object> headers = new HashMap<String, Object>();
        HashMap<String, Object> body = new HashMap<String, Object>();
        HashMap<String, Object> qParams = new HashMap<String, Object>();

        headers.put("Content-Type", "application/json");
        headers.put("Authorization", authorizationHeaderValue);

        qParams.put("country_iso","US");

        Response res =  restApiCall.response_from_api("get", url, qParams, headers, null);
        System.out.println(res.body());
        return res;
    }


}
