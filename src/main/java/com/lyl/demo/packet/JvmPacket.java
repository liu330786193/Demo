package com.lyl.demo.packet;

import java.util.LinkedHashMap;
import java.util.Map;

public class JvmPacket extends BasePacket {

    // 存储KEY-VALUE
    private Map<Object, Object> data = new LinkedHashMap<Object, Object>();

    public Map<Object, Object> getData() {
        return data;
    }

    public void setData(Map<Object, Object> data) {
        this.data = data;
    }
}
