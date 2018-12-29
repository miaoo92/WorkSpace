package com.segmentfault.spring.boot.lesson9.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/10/24
 */
@Document(indexName = "book" ,type = "it")
public class Book implements Serializable{

    private String id;

    private String name;

    private Float price;

    private Date publishDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
