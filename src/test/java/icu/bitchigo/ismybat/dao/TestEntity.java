package icu.bitchigo.ismybat.dao;

import icu.bitchigo.ismybat.anotation.DBFieldIgnore;
import icu.bitchigo.ismybat.anotation.DBStartTime;

import java.util.List;

public class TestEntity {
    private String name;
    @DBStartTime(fieldName = "age")
    private Integer age;
    private int age1;
    private Long l;
    private long l2;

    private List<String> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getAge1() {
        return age1;
    }

    public void setAge1(int age1) {
        this.age1 = age1;
    }

    public Long getL() {
        return l;
    }

    public void setL(Long l) {
        this.l = l;
    }

    public long getL2() {
        return l2;
    }

    public void setL2(long l2) {
        this.l2 = l2;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
