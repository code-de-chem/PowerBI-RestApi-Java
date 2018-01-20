package com.beehyv.powerbi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TIleImage {
    @JsonProperty("imageUrl")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "TIleImage{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
