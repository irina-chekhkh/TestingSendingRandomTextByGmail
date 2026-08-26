package com;

import java.util.ResourceBundle;

public class ResourcesDataReader {
    private final ResourceBundle resources;

    public ResourcesDataReader(String resources) {
        this.resources = ResourceBundle.getBundle(resources);
    }

    public String getData(String key) {
        return resources.getString(key);
    }
}
