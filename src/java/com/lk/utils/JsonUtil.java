/* * Copyright (c) 2014 Qunar.com. All Rights Reserved. */
package com.lk.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

@Slf4j
public class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        SimpleModule module = new SimpleModule("DateTimeModule", Version.unknownVersion());
        module.addSerializer(Date.class, new DateJsonSerializer());
        module.addDeserializer(Date.class, new DateJsonDeserializer());
        module.addSerializer(Timestamp.class, new TimcstampJsonSerializer());
        module.addDeserializer(Timestamp.class, new TimestampJsonDeserializer());
        objectMapper.registerModule(module);
    }

    public static ObjectMapper getInstance() {
        return objectMapper;
    }

    /**
     * 解析成json
     *
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        try {
            return getInstance().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json format error: " + obj, e);
        }
    }

    /**
     * 解析成json
     *
     * @param obj
     * @return 抛异常时返回空字符串
     */
    public static String toStringWithoutException(Object obj) {
        try {
            return getInstance().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("to json error", e);
            return StringUtils.EMPTY;
        }
    }

    /**
     * 解析json
     *
     * @param json
     * @return
     */
    public static ValueNode parse(String json) {

        try {
            return getInstance().readValue(json, ValueNode.class);
        } catch (Exception e) {
            throw new RuntimeException("json parse error :" + json.substring(0, Math.min(100, json.length())), e);
        }
    }

    /**
     * 从JSON Object串中获取ObjectNode类型的值
     */
    public static ObjectNode parseToJsonNode(String jsonString) {
        if (Strings.isNullOrEmpty(jsonString)) {
            return null;
        }
        ObjectNode json;
        try {
            json = getInstance().readValue(jsonString, ObjectNode.class);
            return json;
        } catch (Exception e) {
            throw new RuntimeException("json parse error :" + jsonString.substring(0, Math.min(100, jsonString.length())), e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T parseJson(String json, Class<T> tClass) throws IOException {
        return objectMapper.readValue(json, tClass);
    }

    public static <T> T parseJsonWithoutException(String json, Class<T> tClass) {
        try {
            return objectMapper.readValue(json, tClass);
        } catch (IOException e) {
            return null;
        }
    }

    public static <T> T parseJson(String json, TypeReference<T> tr) throws IOException {
        return objectMapper.readValue(json, tr);
    }

    /**
     * 构造泛型的Collection Type如:
     * ArrayList<MyBean>, 则调用constructCollectionType(ArrayList.class,MyBean.class)
     * HashMap<String,MyBean>, 则调用(HashMap.class,String.class, MyBean.class)
     * <p>
     * 从json中构造复杂的对象
     *
     * @param json            json
     * @param collectionClass
     * @param elementClass
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T complexFromJson(String json, Class<?> collectionClass, Class<?>... elementClass) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClass);

        try {
            return (T) objectMapper.readValue(json, javaType);
        } catch (IOException e) {
            LOGGER.warn("parse json string error:" + json, e);
            return null;
        }
    }


    public static class DateJsonDeserializer extends JsonDeserializer<Date> {

        private final static String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                throws IOException, JsonProcessingException {
            String date = jsonParser.getText();
            if (date != null && !date.isEmpty()) {
                try {
                    return DateUtils.parseDate(date, DATE_PATTERN);
                } catch (ParseException e) {
                    throw new JsonParseException("cannot parse date string: " + date, jsonParser.getCurrentLocation(), e);
                }
            }
            return null;
        }

    }

    public static class DateJsonSerializer extends JsonSerializer<Date> {
        public static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance(DateJsonDeserializer.DATE_PATTERN);

        @Override
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException, JsonProcessingException {
            jsonGenerator.writeString(date != null ? DATE_FORMAT.format(date) : "null");
        }
    }

    public static class TimcstampJsonSerializer extends JsonSerializer<Timestamp> {
        public static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance(DateJsonDeserializer.DATE_PATTERN);

        @Override
        public void serialize(Timestamp date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException, JsonProcessingException {
            jsonGenerator.writeString(date != null ? DATE_FORMAT.format(date) : "null");
        }
    }

    public static class TimestampJsonDeserializer extends JsonDeserializer<Timestamp> {
        public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

        @Override
        public Timestamp deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException,
                JsonProcessingException {
            String date = jsonParser.getText();
            if (date != null && !date.isEmpty()) {
                try {
                    return new Timestamp(DateUtils.parseDate(date, DATE_PATTERN).getTime());
                } catch (ParseException e) {
                    throw new JsonParseException("cannot parse date string: " + date, jsonParser.getCurrentLocation(), e);
                }
            }
            return null;
        }
    }
}
