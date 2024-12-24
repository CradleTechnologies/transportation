package com.cradletechnologies.transportation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CheckAccountBalanceAsyncResponse {

    @JsonProperty("Result")
    private Result result;
}
