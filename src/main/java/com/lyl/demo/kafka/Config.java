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

    public static class Agent {
        /**
         * Application code is showed in sky-walking-ui. Suggestion: set an unique name for each application, one
         * application's nodes share the same code.
         */
        public static String APPLICATION_NAME = "lyl";

        /**
         * 10 seconds tops.
         */
        public static int SAMPLE_N_PER_3_SECS = -1;

        /**
         * If the operation name of the first span is included in this set, this segment should be ignored.
         */
        public static String IGNORE_SUFFIX = ".jpg,.jpeg,.js,.css,.png,.bmp,.gif,.ico,.mp3,.mp4,.html,.svg";

        /**
         * The max number of spans in a single segment. Through this config item, skywalking keep your application
         * memory cost estimated.
         */
        public static int SPAN_LIMIT_PER_SEGMENT = 300;

        /**
         * If true, skywalking agent will save all instrumented classes files in `/debugging` folder.
         * Skywalking team may ask for these files in order to resolve compatible problem.
         */
        public static boolean IS_OPEN_DEBUGGING_CLASS = false;
    }

    public static class Jvm {
        /**
         * The buffer size of collected JVM info.
         */
        public static int BUFFER_SIZE = 60 * 10;
    }

    public static class Buffer {
        public static int CHANNEL_SIZE = 5;

        public static int BUFFER_SIZE = 300;
    }

    public static class Packet {

        // 数据包是否发送至远程数据.默认为true.为false时会落到本地磁盘
        public static boolean REMOTE = true;

        // 发送到kafka的topic
        public static String TOPIC = "monitor-agent";

        // KAFKA地址
//        public static String SERVER = "10.31.55.56:6667;10.31.55.29:6667;10.31.55.53:6667";
        public static String SERVER = "192.168.8.238:9092";
    }

    public static class Dictionary {
        /**
         * The buffer size of application codes and peer
         */
        public static int APPLICATION_CODE_BUFFER_SIZE = 10 * 10000;

        public static int OPERATION_NAME_BUFFER_SIZE = 1000 * 10000;
    }

    public static class Logging {
        /**
         * Log file name.
         */
        public static String FILE_NAME = "cat-api.log";

        /**
         * Log files directory. Default is blank string, means, use "system.out" to output logs.
         *
         */
        public static String DIR = "";

        /**
         * The max size of log file. If the size is bigger than this, archive the current file, and write into a new
         * file.
         */
        public static int MAX_FILE_SIZE = 300 * 1024 * 1024;

    }

}
