package com.kiwa.utils;

import java.util.HashMap;
import java.util.Map;

public class R {
    private static final HashMap<String, Object> map = new HashMap<String, Object>();

    public static Map<String, Object> succeed(String msg) {
        map.put("msg", msg);
        map.put("code", 200);
        return map;
    }

    public static Map<String, Object> succeed(String msg, Object data) {
        map.put("code", 200);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    public static Map<String, Object> succeed(int code, String msg, Object data) {
        map.put("msg", msg);
        map.put("data", data);
        map.put("code", code);
        return map;
    }

}
