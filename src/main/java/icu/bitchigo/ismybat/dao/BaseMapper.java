package icu.bitchigo.ismybat.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 基础映射器
 *
 * @author bitchigo
 * @date 2022/09/18
 */
public interface BaseMapper<T> {

    /**
     * 根据实体类查询
     *
     * @param po 采购订单
     * @return {@link List}<{@link T}>
     */
    @SelectProvider(type = SQlProvider.class, method = "selectByPo")
    List<T> selectByPo(T po);

    /**
     * 插入列表
     *
     * @param list 列表
     */
    @InsertProvider(type = SQlProvider.class, method = "insertList")
    void insertList(List<T> list);




}
