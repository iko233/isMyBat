package icu.bitchigo.ismybat.dao;


/**
 * sql提供程序
 *
 * @author bitchigo
 * @date 2022/09/18
 */
class SQlProvider {

    public <T> String selectByPo(T table) {
        String[] fields = EntityHelper.getSqlFields(table.getClass());
        StringBuilder sqlBuilder = new StringBuilder();
        SqlHelper.select(sqlBuilder, EntityHelper.getTableName(table.getClass()), fields);
        SqlHelper.where(sqlBuilder,table);
        return sqlBuilder.toString();
    }

    public <T> String selectPage(T table, int page, int size) {
        if (size <= 0) {
            return selectByPo(table);
        }
        String[] fields = EntityHelper.getSqlFields(table.getClass());
        StringBuilder sqlBuilder = new StringBuilder();
        SqlHelper.select(sqlBuilder, EntityHelper.getTableName(table.getClass()), fields);
        SqlHelper.where(sqlBuilder,table);
        SqlHelper.limit(sqlBuilder,page,size);
        return sqlBuilder.toString();
    }



}
