package com.segmentfault.spring.boot.domain;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/10/25
 */
public class Track {

    private String name;

    private Integer length;

    public Track(String name, Integer length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }
}
