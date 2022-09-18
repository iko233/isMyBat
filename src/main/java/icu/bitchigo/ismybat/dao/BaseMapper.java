package icu.bitchigo.ismybat.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface BaseMapper<T> {

    @SelectProvider(type = SQlProvider.class, method = "selectByPo")
    List<T> selectByPo(T po);

    @InsertProvider(type = SQlProvider.class, method = "insertList")
    void insertList(List<T> list);




}
