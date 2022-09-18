package icu.bitchigo.ismybat.dao;

import java.util.ArrayList;

public class SqlHelperTest {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        TestEntity testEntity = new TestEntity();
        testEntity.setName("nameValue");
        testEntity.setAge(1);
        testEntity.setAge1(2);
        testEntity.setL(1L);
        testEntity.setL2(2L);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        testEntity.setList(strings);
        SqlHelper.select(stringBuilder,testEntity);
        SqlHelper.where(stringBuilder,testEntity);
        SqlHelper.limit(stringBuilder,2,10);
        System.out.println(stringBuilder);
    }
}
