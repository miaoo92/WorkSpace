package com.gupaoedu.vip.restonspringwebmvc.http.message;

import com.gupaoedu.vip.restonspringwebmvc.domain.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesPersonHttpMessageConverter extends AbstractHttpMessageConverter<Person> {

    public PropertiesPersonHttpMessageConverter() {
        super(MediaType.valueOf("application/properties+person"));
        setDefaultCharset(Charset.forName("UTF-8"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * 将请求内容中Properties内容转化成Person对象
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected Person readInternal(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        InputStream inputStream = inputMessage.getBody();
        Properties properties = new Properties();
        //将请求体转化成Properties
        properties.load(new InputStreamReader(inputStream,getDefaultCharset()));
        //将Properties内容转化到person对象字段中
        Person person = new Person();
        person.setId(Long.valueOf(properties.getProperty("person.id")));
        person.setName(String.valueOf(properties.getProperty("person.name")));
        return person;
    }

    @Override
    protected void writeInternal(Person person, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        Properties properties = new Properties();

        properties.setProperty("person.id",String.valueOf(person.getId()));
        properties.setProperty("person.name",person.getName());
        OutputStream outputStream = outputMessage.getBody();
        properties.store(new OutputStreamWriter(outputStream),"writen by server");


    }
}
