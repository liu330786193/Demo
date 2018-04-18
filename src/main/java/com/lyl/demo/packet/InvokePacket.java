package com.lyl.demo.packet;

import java.util.ArrayList;
import java.util.List;

public class InvokePacket extends BasePacket implements Cloneable{

    private List<Invoke> data = new ArrayList<Invoke>();

    public List<Invoke> getData() {
        return data;
    }

    public void setData(List<Invoke> data) {
        this.data = data;
    }

    public InvokePacket clone() throws CloneNotSupportedException {
        return (InvokePacket)super.clone();
    }
}

