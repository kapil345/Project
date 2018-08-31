package com.plivo.services;

import com.jayway.restassured.response.Response;
import com.plivo.Base.Base;
import com.plivo.Utils.ConfigUtil;
import com.plivo.Utils.PlivoConstants;
import com.plivo.helpers.ApiHelpers;
import com.plivo.models.responsemodels.MessageDAO;

import java.util.HashMap;

public class SendMessage extends Base {


    ApiHelpers restApiCall = new ApiHelpers();


    public Response sendMessageToGivenNummber(String src,String des){

        String url = ConfigUtil.getDataFromConfig("base_url") + PlivoConstants.SEND_MESSAGE;
        HashMap<String, Object> headers = new HashMap<String, Object>();
        HashMap<String, Object> body = new HashMap<String, Object>();
        HashMap<String, Object> qParams = new HashMap<String, Object>();

        body.put("src","14158408589");
        body.put("dst","14158408583");
        body.put("text","this is simple text");
        body.put("type","sms");
        body.put("url","");
        body.put("method","");
        body.put("log",true);
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", authorizationHeaderValue);

        Response res =  restApiCall.response_from_api("post", url, null, headers, body);
        res.body().print();
        return res;
    }
}
