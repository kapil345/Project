package com.plivo.Utils;

public interface PlivoConstants {

   public String NUMBER = "/Number/";
   public String NUMBER_DETAIL = "/v1/Account/MAODUZYTQ0Y2FMYJBLOW/Number/";
   public String SEND_MESSAGE = "/Message/";
   public String PRICING = "/Pricing";
 ///  public String ACCOUNT_DETAILS = "/v1/Account/MAODUZYTQ0Y2FMYJBLOW/";
   public String SENT_MESSAGE_DETAILS = "/Message/";


   public static final String DEFAULT_URL = "https://api.plivo.com";

   public static final String BASE_END_POINT = "/v1/Account/";

   public static final String STAGING_CONFIG_FILE_PATH = System.getProperty("user.dir") + "/resources/config.properties";

   public static final String PROD_CONFIG_FILE_PATH = System.getProperty("user.dir") + "/resources/production.properties";

}
