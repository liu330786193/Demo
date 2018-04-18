package com.lyl.demo.packet;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mozilla
 */
public class Invoke{
    private String target;
    // 聚合调用信息
    private Map<Object, Object> values = new LinkedHashMap<Object, Object>();

    private List<Client> client = null;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }

    public Map<Object, Object> getValues() {
        return values;
    }

    public void setValues(Map<Object, Object> values) {
        this.values = values;
    }
}