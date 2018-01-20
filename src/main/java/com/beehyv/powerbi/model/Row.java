package com.beehyv.powerbi.model;

public class Row {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Row{" +
                "id='" + id + '\'' +
                '}';
    }
}
