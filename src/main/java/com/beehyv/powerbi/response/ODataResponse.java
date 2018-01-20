package com.beehyv.powerbi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ODataResponse<T> {
    @JsonProperty("@odata.context")
    private String oDataContext;
    private List<T> value;

    public ODataResponse() {
    }

    public String getoDataContext() {
        return oDataContext;
    }

    public void setoDataContext(String oDataContext) {
        this.oDataContext = oDataContext;
    }

    public List<T> getValue() {
        return value;
    }

    public void setValue(List<T> value) {
        this.value = value;
    }
}
