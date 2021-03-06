package com.lyl.demo.encrypt;


import com.tsign.cat.api.config.TopicEnum;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class ProtobufDeserializer<T> implements Deserializer<T> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public T deserialize(String topic, byte[] data) {
        if (data == null){
            return null;
        }
        Class<T> clazz = TopicEnum.matchFor(topic).topicClass;
        Schema schema = RuntimeSchema.getSchema(clazz);
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProtobufIOUtil.mergeFrom(data, t, schema);
        return t;
    }

    @Override
    public void close() {

    }
}
