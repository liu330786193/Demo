package com.lyl.demo.kafka;

import com.lyl.demo.packet.JvmPacket;

import java.util.EnumSet;

public enum TopicConfig {

//    DEMO("monitor-agent", Data.class, new Data());
    DEMO("monitor-agent1", JvmPacket.class, new JvmPacket());

    public final String topicName;
    public final Class topicClass;
    public final Object topicObject;

    TopicConfig(String topicName, Class topicClass, Object topicObject){
        this.topicClass = topicClass;
        this.topicName = topicName;
        this.topicObject = topicObject;
    }

    public static TopicConfig matchFor(String topicName){
        return EnumSet.allOf(TopicConfig.class).stream()
                .filter(topic -> topic.topicName.equals(topicName))
                .findFirst()
                .orElse(null);
    }



}
