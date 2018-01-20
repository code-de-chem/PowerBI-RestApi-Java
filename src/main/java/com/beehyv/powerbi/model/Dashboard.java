package com.beehyv.powerbi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Dashboard {
    private String id;
    private String displayName;
    private String embedUrl;
    @JsonProperty("isReadOnly")
    private boolean isReadOnly;

    private List<Tile> tiles;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(boolean readOnly) {
        isReadOnly = readOnly;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    @Override
    public String toString() {
        return "Dashboard{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", embedUrl='" + embedUrl + '\'' +
                ", isReadOnly=" + isReadOnly +
                ", tiles=" + tiles +
                '}';
    }
}
