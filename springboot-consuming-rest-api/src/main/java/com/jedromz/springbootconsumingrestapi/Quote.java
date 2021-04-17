package com.jedromz.springbootconsumingrestapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;




@JsonIgnoreProperties(ignoreUnknown = true) //any properties not bound by this type should be ignored
@Data
public class Quote {
    private String type;
    private Value value;
}
