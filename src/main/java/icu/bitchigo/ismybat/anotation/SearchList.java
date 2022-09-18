package icu.bitchigo.ismybat.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标注为搜索列表
 *
 * @author bitchigo
 * @date 2022/09/18
 */
@DBFieldIgnore
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SearchList {
    /**
     * 字段名
     *
     * @return {@link String}
     */
    String fieldName();
}
