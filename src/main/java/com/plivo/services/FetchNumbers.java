package com.plivo.services;

import com.jayway.restassured.response.Response;
import com.plivo.Base.Base;
import com.plivo.Utils.ConfigUtil;
import com.plivo.Utils.PlivoConstants;
import com.plivo.helpers.ApiHelpers;
import com.plivo.models.responsemodels.AllNumbersDAO;

import java.util.HashMap;

public class FetchNumbers extends Base {

    ApiHelpers restApiCall = new ApiHelpers();

    public Response getNumbers() {
        String url = ConfigUtil.getDataFromConfig("base_url") + PlivoConstants.NUMBER;
        HashMap<String, Object> headers = new HashMap<String, Object>();
        HashMap<String, Object> body = new HashMap<String, Object>();
        HashMap<String, Object> qParams = new HashMap<String, Object>();

        headers.put("Content-Type", "application/json");
        headers.put("Authorization", authorizationHeaderValue);
        Response res = restApiCall.response_from_api("get", url, null, headers, null);
        res.body().print();
        AllNumbersDAO allNumbersDAO = ApiHelpers.get_Gson_from_Json(AllNumbersDAO.class, res);
        return res;
    }
}
