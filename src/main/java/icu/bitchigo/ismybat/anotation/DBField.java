package icu.bitchigo.ismybat.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 调整字段属性对应数据库字段名称注解
 *
 * @author bitchigo
 * @date 2022/09/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DBField {
    /**
     * 名称
     *
     * @return {@link String}
     */
    String name();
}
