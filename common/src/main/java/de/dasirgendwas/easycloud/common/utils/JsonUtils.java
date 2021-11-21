package de.dasirgendwas.easycloud.common.utils;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

public class JsonUtils {

    public static boolean isValidJson(String json, Class<?> clazz) {
        try {
            new Gson().fromJson(json, clazz);
            return true;
        } catch (JsonParseException jsonParseException) {
            return false;
        }
    }

}
