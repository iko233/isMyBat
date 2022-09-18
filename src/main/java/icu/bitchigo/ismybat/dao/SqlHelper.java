package icu.bitchigo.ismybat.dao;
import icu.bitchigo.ismybat.db.IEnum;
import icu.bitchigo.ismybat.util.StringUtil;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * sql助手
 *
 * @author bitchigo
 * @date 2022/09/18
 */
class SqlHelper {

    /**
     * 生成select语句
     *
     * @param builder 字符串构造器
     * @param table   表
     * @param fields  属性
     */
    public static void select(StringBuilder builder, String table, String[] fields) {
        builder.append(" SELECT \n    ");
        builder.append(String.join(",", fields));
        builder.append("\n FROM \n    ");
        builder.append(table);
    }

    /**
     * 生成select语句
     *
     * @param builder 字符串构造器
     * @param table   表
     */
    public static <T> void select(StringBuilder builder, T table) {
        builder.append(" SELECT \n    ");
        builder.append(String.join(",", EntityHelper.getSqlFields(table.getClass())));
        builder.append("\n FROM \n    ");
        builder.append(EntityHelper.getTableName(table.getClass()));
    }

    /**
     * 生成where语句
     *
     * @param builder 字符串构造器
     * @param table   实体
     */
    public static <T> void where(StringBuilder builder, T table) {
        Class<?> clazz = table.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        List<String> whereList = new ArrayList<>(declaredFields.length);
        for (Field field : declaredFields) {
            Object fieldValue = null;
            Class<?> fieldType = field.getType();
            String fieldName = field.getName();
            String sqlFieldName = StringUtil.toUpperUnderline(fieldName);
            if (!field.canAccess(table)) {
                field.setAccessible(true);
            }
            try {
                fieldValue = field.get(table);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
            if (fieldValue != null) {
                //todo 以后改策略模式
                if (fieldType == String.class) {
                    whereList.add(whereEqual(sqlFieldName, (String) fieldValue));
                    continue;
                }
                if (fieldType == Integer.class) {
                    whereList.add(whereEqual(sqlFieldName, (Integer) fieldValue));
                    continue;
                }
                if (fieldType == Long.class) {
                    whereList.add(whereEqual(sqlFieldName, (Long) fieldValue));
                    continue;
                }
                if (fieldType == List.class){
                    whereList.add(whereIn(sqlFieldName,(List<Serializable>) fieldValue));
                    continue;
                }
                if (fieldType == IEnum.class){
                    whereList.add(whereEqual(sqlFieldName,((IEnum)fieldValue).getCode()));
                }
            }
        }
        if (whereList.size() > 0) {
            builder.append("\n WHERE \n   ");
            builder.append(String.join(" AND \n   ", whereList));
        }
    }

    /**
     * 生成where in sql
     *
     * @param sqlFieldName sql字段名
     * @param list         列表
     * @return {@link String}
     */
    public static String whereIn(String sqlFieldName,List<Serializable> list){
        StringBuilder builder = new StringBuilder();
        builder.append(" ");
        builder.append(sqlFieldName);
        builder.append(" IN (");
        builder.append(list.stream().map(o->"'"+o+"'").collect(Collectors.joining(",")));
        builder.append(") ");
        return builder.toString();
    }

    /**
     * 生成where equal sql
     *
     * @param sqlFieldName sql字段名
     * @param fieldValue   字段值
     * @return {@link String}
     */
    public static String whereEqual(String sqlFieldName, Serializable fieldValue) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ");
        builder.append(sqlFieldName);
        builder.append(" = '");
        builder.append(fieldValue);
        builder.append("' ");
        return builder.toString();
    }

    /**
     * 生成limit sql
     *
     * @param builder 字符串构造器
     * @param page    页数
     * @param size    大小
     */
    public static void limit(StringBuilder builder, int page, int size) {
        builder.append("\n LIMIT ");
        builder.append((page - 1) * size);
        builder.append(",");
        builder.append(size);
    }

}
