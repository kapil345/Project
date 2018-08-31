package com.plivo.services;

import com.jayway.restassured.response.Response;
import com.plivo.Base.Base;
import com.plivo.Utils.ConfigUtil;
import com.plivo.Utils.PlivoConstants;
import com.plivo.helpers.ApiHelpers;
import com.plivo.models.responsemodels.SentMessageDetailsDAO;

import java.util.HashMap;

public class SentMessageDetails  extends Base{

    ApiHelpers restApiCall = new ApiHelpers();


    public Response getSentMessagePricingData(String m_uuid ){

        String url = ConfigUtil.getDataFromConfig("base_url") + PlivoConstants.SENT_MESSAGE_DETAILS+m_uuid+"/";
        HashMap<String, Object> headers = new HashMap<String, Object>();
        HashMap<String, Object> body = new HashMap<String, Object>();
        HashMap<String, Object> qParams = new HashMap<String, Object>();

        headers.put("Content-Type", "application/json");
        headers.put("Authorization", authorizationHeaderValue);

        Response res =  restApiCall.response_from_api("get", url, null, headers,null);
        res.body().print();

        return res;

    }






}
