package com.plivo.services;

import com.jayway.restassured.response.Response;
import com.plivo.Base.Base;
import com.plivo.Utils.ConfigUtil;
import com.plivo.Utils.PlivoConstants;
import com.plivo.helpers.ApiHelpers;
import com.plivo.models.responsemodels.AccountDetailsDAO;

import java.util.HashMap;

public class AccountDetails extends Base {


    ApiHelpers restApiCall = new ApiHelpers();

    public Response getAccountDetailsofPlivoAccount(){

        String url = ConfigUtil.getDataFromConfig("base_url") + PlivoConstants.ACCOUNT_DETAILS;
        HashMap<String, Object> headers = new HashMap<String, Object>();
        HashMap<String, Object> body = new HashMap<String, Object>();
        HashMap<String, Object> qParams = new HashMap<String, Object>();

        headers.put("Content-Type", "application/json");
        headers.put("Authorization", authorizationHeaderValue);

        Response res =  restApiCall.response_from_api("get", url, null, headers, null);
        res.body().print();
        AccountDetailsDAO accountDetailsDAO = ApiHelpers.get_Gson_from_Json(AccountDetailsDAO.class,res);
        return res;

    }



}
