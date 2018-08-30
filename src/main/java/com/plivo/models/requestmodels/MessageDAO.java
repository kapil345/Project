package com.plivo.models.requestmodels;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDAO {

    private String src;
    private String dst;
    private String text;
    private String type;
    private String url;
    private String method;
    private Boolean log;

}
