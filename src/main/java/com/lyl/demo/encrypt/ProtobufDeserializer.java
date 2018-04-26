package com.lyl.demo.encrypt;


import com.tsign.cat.core.kafka.config.TopicConfig;
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
        TopicConfig topicConfig = TopicConfig.matchFor(topic);
        Schema schema = RuntimeSchema.getSchema(topicConfig.topicClass);
        T t = (T) topicConfig.topicObject;
        ProtobufIOUtil.mergeFrom(data, (T) topicConfig.topicObject, schema);
        return t;
    }

    @Override
    public void close() {

    }
}
