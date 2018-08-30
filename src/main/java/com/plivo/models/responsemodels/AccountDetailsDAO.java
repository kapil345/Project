package com.plivo.models.responsemodels;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetailsDAO {

   private String account_type;
   private String address;
   private String api_id;
   private String auth_id;
   private Boolean auto_recharge;
   private String billing_mode;
   private String cash_credits;
   private String city;
   private String name;
   private String resource_uri;
   private String state;
   private String timezone;

}
