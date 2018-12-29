package com.segmentfault.springbootlesson11.serializer;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * User序列化器
 *
 * @author miaoo
 * @since 2018/11/9
 */
public class UserSerializer implements Serializer<Object> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Object data) {
        System.out.println("topic: "+topic +",User:"+data);
        byte[] dataArray = null;
        ByteOutputStream outputStream = new ByteOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(data);
            dataArray = outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataArray;
    }

    @Override
    public void close() {

    }
}
