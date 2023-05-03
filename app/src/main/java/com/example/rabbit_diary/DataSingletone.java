package com.example.rabbit_diary;

import java.util.HashMap;

public class DataSingletone {
    private static DataSingletone instance;

    private HashMap<String, String> data;

    public DataSingletone() {
        data = new HashMap<>();
    }

    public static DataSingletone getInstance() {
        if(instance==null) {
            instance = new DataSingletone();
        }
        return instance;
    }

    public String get(String key) {
        return this.data.get(key);
    }
    public String get(String key, String defaultValue) {
        if(this.data.containsKey(key)) {
            return this.data.get(key);
        }
        return defaultValue;
    }

    public void set(String key, String value) {
        this.data.put(key,value);
    }
}
