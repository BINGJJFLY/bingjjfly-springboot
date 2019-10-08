package com.wjz.msgconvert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectSerializer;

import java.io.IOException;

public class NullValueSerializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        try {
            jgen.writeString("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
