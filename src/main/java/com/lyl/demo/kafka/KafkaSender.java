package com.lyl.demo.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaSender {

    private static final KafkaSender INSTANCE = new KafkaSender();

    private Producer producer;

    private KafkaSender(){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", Config.Kafka.BOOTSTRAP_SERVERS);
        properties.put("acks", Config.Kafka.ACKS);
        properties.put("retries", Config.Kafka.RETRIES);
        properties.put("batch.size", Config.Kafka.BATCH_SIZE);
        properties.put("linger.ms", Config.Kafka.LINGER_MS);
        properties.put("buffer.memory", Config.Kafka.BUFFER_MEMORY);
//        properties.put("compression.type", "snappy");
        properties.put("key.serializer", Config.Kafka.KEY_SERIALIZER);
        properties.put("value.serializer", Config.Kafka.VALUE_SERIALIZER);
/*        properties.put("key.deserializer", Config.Kafka.KEY_DESERIALIZER);
        properties.put("value.deserializer", Config.Kafka.VALUE_DESERIALIZER);*/
        this.producer = new KafkaProducer<String, String>(properties);
    }


    public void send(String packet){
        producer.send(new ProducerRecord<String, String>(Config.Kafka.TOPIC, packet));
    }

    public void send(ProducerRecord record){
        producer.send(record);
    }

    public static KafkaSender getInstance(){
        return INSTANCE;
    }

}
