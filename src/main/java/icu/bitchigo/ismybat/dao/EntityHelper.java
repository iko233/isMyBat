package icu.bitchigo.ismybat.dao;

import icu.bitchigo.ismybat.anotation.DBField;
import icu.bitchigo.ismybat.anotation.DBFieldIgnore;
import icu.bitchigo.ismybat.anotation.DBTable;
import icu.bitchigo.ismybat.util.StringUtil;

import java.util.Arrays;

public class EntityHelper {

    public static String getTableName(Class<?> clazz) {
        DBTable annotation = clazz.getAnnotation(DBTable.class);
        if (annotation != null && StringUtil.isNotEmpty(annotation.name())) {
            return annotation.name();
        }
        String tableName = clazz.getSimpleName();
        return StringUtil.toUpperUnderline(tableName);
    }

    public static String[] getSqlFields(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> null == f.getAnnotation(DBFieldIgnore.class))
                .map((f) -> {
                    DBField annotation = f.getAnnotation(DBField.class);
                    return annotation != null &&
                            null == f.getAnnotation(DBFieldIgnore.class) &&
                            StringUtil.isNotEmpty(annotation.name()) ?
                            annotation.name() : StringUtil.toUpperUnderline(f.getName());
                })
                .toArray(String[]::new);
    }

}
