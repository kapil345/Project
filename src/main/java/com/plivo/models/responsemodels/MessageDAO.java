package com.plivo.models.responsemodels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDAO {

  //  private String api_id;
   // private String message;
  //  MessageUuid message_uuid;


    String api_id;
    String message;
    String[] message_uuid;




}
