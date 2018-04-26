package com.lyl.demo.packet;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author mozilla
 */
public class Client {

    private String ip;
    private long timestamp;
    private Map<Object, Object> detail = new LinkedHashMap<Object, Object>();

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<Object, Object> getDetail() {
        return detail;
    }

    public void setDetail(Map<Object, Object> detail) {
        this.detail = detail;
    }
}
