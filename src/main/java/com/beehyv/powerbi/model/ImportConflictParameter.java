package com.beehyv.powerbi.model;

public enum ImportConflictParameter {

    IGNORE("Ignore"),
    ABORT("Abort"),
    OVERWRITE("Overwrite");

    private final String param;

    private ImportConflictParameter(String param){
        this.param = param;
    }

    public String getParam() {
        return param;
    }

    public static ImportConflictParameter getValueOf(String param){
        return ImportConflictParameter.valueOf(param.toUpperCase());
    }

    @Override
    public String toString() {
        return param;
    }
}
