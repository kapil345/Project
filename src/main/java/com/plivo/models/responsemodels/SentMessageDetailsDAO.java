package com.plivo.models.responsemodels;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SentMessageDetailsDAO {

    private  String api_id;
    private String error_code;
    private  String from_number;
    private String message_direction;
    private String message_state;
    private String message_time;
    private String message_type;
    private String message_uuid;
    private String resource_uri;
    private String to_number;
    private String total_amount;
    private String total_rate;
    private String units;

}
