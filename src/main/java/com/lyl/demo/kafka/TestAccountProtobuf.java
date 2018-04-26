package com.lyl.demo.kafka;


import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.kafka.clients.producer.ProducerRecord;

public class TestAccountProtobuf {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        /*long st = System.currentTimeMillis();
        for (int i = 0; i< 10000000; i++){
            test1();
        }
        System.out.println("时间：" + (System.currentTimeMillis() - st));
        long st1 = System.currentTimeMillis();
        for (int i = 0; i< 10000000; i++){
            test2();
        }
        System.out.println("时间：" + (System.currentTimeMillis() - st1));*/
        test2();
        test2();
        test2();
    }

    private static void test2(){
        Data d = new Data();
        d.setAltitude(1);
        d.setDataTime("2017-12-17 16:21:44");
        d.setGpsStatus(1);
        d.setLat(39.123);
        d.setLon(120.112);
        d.setDirection(30.2F);
        d.setId(100L);
        /*String s = JSON.toJSONString(d);
        Data data = JSON.parseObject(s, Data.class);*/

//        KafkaSender.getInstance().send(new ProducerRecord<String, Data>(Config.Kafka.TOPIC, d));

        KafkaReceiver.getInstance().getMsgFromKafka();
    }

}
