package com.fast.framework.common.utils;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * JSON工具-jackson
 *
 * @author liaojunjie
 * @date 2023/2/9 16:43
 */
public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String toJsonString(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> T parseObject(String text, Class<T> tClass){
        if (StrUtil.isEmpty(text)){
            return null;
        }
        try {
            return objectMapper.readValue(text,tClass);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> T parseObject(byte[] bytes,Class<T> tClass){
        if (ArrayUtil.isEmpty(bytes)){
            return null;
        }
        try {
            return objectMapper.readValue(bytes,tClass);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> T parseObject(String text, TypeReference<T> tClass){
        if (StrUtil.isEmpty(text)){
            return null;
        }
        try {
            return objectMapper.readValue(text,tClass);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> parseArray(String text, Class<T> tClass){
        if (StrUtil.isEmpty(text)){
            return new ArrayList<T>();
        }
        try {
            return objectMapper.readValue(text,objectMapper.getTypeFactory().constructCollectionType(List.class,tClass));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
