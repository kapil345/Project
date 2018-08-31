package com.plivo.helpers;


import com.google.gson.Gson;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.plivo.Utils.LoggerUtils;

import javax.imageio.ImageIO;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import static com.jayway.restassured.RestAssured.given;

public class ApiHelpers {

	public static int responseCode = 0;
	public static String responseString;

	public RequestSpecification get_reqspec() {
		return given().contentType("application/json").when().with();
	}

	public RequestSpecification setHeaders(RequestSpecification specification, Map<?, ?> headers) {

		Set<String> key_set = (Set<String>) headers.keySet();

		for (String key : key_set) {
			specification.header(key, headers.get(key));
		}

		return specification;
	}

	public RequestSpecification setQueryParam(RequestSpecification specification, Map<String, ?> params) {

		specification.queryParameters(params);

		return specification;
	}

	public RequestSpecification setBody(RequestSpecification specification, HashMap<?, ?> body) {
		specification.body(body);
		return specification;
	}

	public RequestSpecification setRequestBody(RequestSpecification specification, Object body) {
		specification.body(body);
		return specification;
	}

	public Response response_from_api(String method, String url, Map<String, ?> qParams, Map<?, ?> headers,
			HashMap<?, ?> body) {
		//LoggerUtils.info("inside response_from_api function");
		Response res = null;
		RequestSpecification spec = null;
		spec = get_reqspec();

		setHeaders(spec, headers);

		if (qParams != null) {
			setQueryParam(spec, qParams);
		}

		if (body != null) {
			setBody(spec, body);
		}

		if (method.equalsIgnoreCase("get")) {

			try {
				res = spec.get(url);
			} catch (Exception e) {
				LoggerUtils.error("Exception for get method in response_from_api function  " + e.getMessage());
				return null;
			}
		}

		else if (method.equalsIgnoreCase("post")) {

			try {
				res = spec.post(url);

			} catch (Exception e) {
				LoggerUtils.error("Exception for post method in response_from_api function  " + e.getMessage());
				return null;
			}

		}

		else if (method.equalsIgnoreCase("put")) {

			try {
				res = spec.put(url);
			} catch (Exception e) {
				LoggerUtils.error("Exception for put method in response_from_api function  " + e.getMessage());
				return null;
			}

		}

		else if (method.equalsIgnoreCase("delete")) {

			try {
				res = spec.delete(url);
			} catch (Exception e) {
				LoggerUtils.error("Exception for delete method in response_from_api function  " + e.getMessage());
				return null;
			}

		}

		else {
			LoggerUtils.debug("Incorrect crud method Passed");
			return null;

		}
		return res;

	}

	public static <T> T get_Gson_from_Json(Class<T> desired_class, Response res) {
		Gson gson = new Gson();
		return gson.fromJson(res.asString(), desired_class);
	}


}
