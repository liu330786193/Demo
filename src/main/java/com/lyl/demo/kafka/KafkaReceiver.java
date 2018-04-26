package com.lyl.demo.kafka;

import com.alibaba.fastjson.JSON;
import com.lyl.demo.packet.JvmPacket;
import org.apache.kafka.clients.consumer.*;

import java.util.Arrays;
import java.util.Properties;

public class KafkaReceiver {

    private static final KafkaReceiver INSTANCE = new KafkaReceiver();

    private Consumer consumer;

    private KafkaReceiver(){
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put("group.id", "test");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", Config.Kafka.KEY_DESERIALIZER);
        properties.put("value.deserializer", Config.Kafka.VALUE_DESERIALIZER);
        this.consumer = new KafkaConsumer(properties);
        consumer.subscribe(Arrays.asList(Config.Kafka.TOPIC));
    }

    public void getMsgFromKafka(){
        ConsumerRecords<String, JvmPacket> records = consumer.poll(100);
        if (records.count() > 0) {
            for (ConsumerRecord<String, JvmPacket> record : records) {
                System.out.println(JSON.toJSONString(record.value()));
            }
        }
    }

    public static KafkaReceiver getInstance(){
        return INSTANCE;
    }

}
