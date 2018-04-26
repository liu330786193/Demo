package com.lyl.demo.kafka;

import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class DemoDeserializer<T> implements Deserializer<T> {

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
        T dataProto = (T) topicConfig.topicObject;
        ProtobufIOUtil.mergeFrom(data, dataProto, schema);
        return dataProto;
    }

    @Override
    public void close() {

    }
}
