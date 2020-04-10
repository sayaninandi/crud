package com.example.crud.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Util {

    private static Logger log = LoggerFactory.getLogger(Util.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) {
        String jsonItem = "{}";
        try {
            jsonItem = objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            log.error("Error converting to Json. StackTrace: {}", e.getStackTrace());
        }
        return jsonItem;
    }
}
