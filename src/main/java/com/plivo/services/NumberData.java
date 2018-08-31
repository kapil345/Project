package com.plivo.services;

import com.jayway.restassured.response.Response;
import com.plivo.Base.Base;
import com.plivo.Utils.ConfigUtil;
import com.plivo.Utils.PlivoConstants;
import com.plivo.helpers.ApiHelpers;
import com.plivo.models.responsemodels.NumberDAO;

import java.util.HashMap;

public class NumberData extends Base {


    ApiHelpers restApiCall = new ApiHelpers();


    public NumberDAO getNumberData(String number){

        String url = ConfigUtil.getDataFromConfig("base_url") + PlivoConstants.NUMBER_DETAIL+"14158408583";
        HashMap<String, Object> headers = new HashMap<String, Object>();
        HashMap<String, Object> body = new HashMap<String, Object>();
        HashMap<String, Object> qParams = new HashMap<String, Object>();

        headers.put("Content-Type", "application/json");
        headers.put("Authorization", authorizationHeaderValue);

        Response res =  restApiCall.response_from_api("get", url, null, headers, null);
        System.out.println(res.body().print());
        NumberDAO numberDAO = ApiHelpers.get_Gson_from_Json(NumberDAO.class,res);
        return numberDAO;

    }



}
