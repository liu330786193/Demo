/*
 * Copyright 2017, OpenSkywalking Organization All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Project repository: https://github.com/OpenSkywalking/skywalking
 */

package com.lyl.demo.kafka;


import com.lyl.demo.encrypt.ProtobufDeserializer;

/**
 * This is the core config in sniffer agent.
 *
 * @author wusheng
 */
public class Config {

    public static class Kafka{

        public static String BOOTSTRAP_SERVERS = "localhost:9092";
        public static String ACKS = "1";
        public static int RETRIES = 0;
        public static int BATCH_SIZE = 65535;
        public static int LINGER_MS = 2000;
        public static int BUFFER_MEMORY = 33554432;
//        public static String KEY_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";
        public static String KEY_SERIALIZER = "com.lyl.demo.kafka.DemoSerializer";
//        public static String VALUE_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";
        public static String VALUE_SERIALIZER = "com.lyl.demo.kafka.DemoSerializer";
        public static String KEY_DESERIALIZER = ProtobufDeserializer.class.getName();
        public static String VALUE_DESERIALIZER = KEY_DESERIALIZER;
    }


}
