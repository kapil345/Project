package com.plivo.models.responsemodels;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NumberDAO {

    private Boolean active;
    private String added_on;
    private String alias;
    private String api_id;
    private String application;
    private String carrier;
    private String city;
    private String country;
    private String monthly_rental_rate;
    private String number;
    private String number_type;
    private String region;
    private String resource_uri;
    private Boolean sms_enabled;
    private String sms_rate;
    private String sub_account;
    private String type;
    private String[] verification_info;
    private Boolean voice_enabled;
    private String voice_rate;

}
