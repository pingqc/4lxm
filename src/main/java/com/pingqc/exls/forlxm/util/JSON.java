package com.pingqc.exls.forlxm.util;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON {

    private static ObjectMapper objectMapper = newObjectMapper();

    public static ObjectMapper newObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return objectMapper;
    }

    private JSON() {
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJsonE(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }

    public static <T> T readJson(Reader jsonReader, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonReader, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readJsonE(Reader jsonReader, Class<T> clazz) throws IOException {
        return objectMapper.readValue(jsonReader, clazz);
    }

    public static String toJson(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJsonE(Object value) throws JsonProcessingException {
        return objectMapper.writeValueAsString(value);
    }

    public static void writeJson(Writer writer, Object value) {
        try {
            objectMapper.writeValue(writer, value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeJsonE(Writer writer, Object value) throws IOException {
        objectMapper.writeValue(writer, value);
    }

}
