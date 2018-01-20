package com.beehyv.powerbi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TIleDefinition {
    @JsonProperty("imageTile")
    private TIleImage imageTile;

    public TIleImage getImageTile() {
        return imageTile;
    }

    public void setImageTile(TIleImage imageTile) {
        this.imageTile = imageTile;
    }

    @Override
    public String toString() {
        return "TIleDefinition{" +
                "imageTile=" + imageTile +
                '}';
    }
}
