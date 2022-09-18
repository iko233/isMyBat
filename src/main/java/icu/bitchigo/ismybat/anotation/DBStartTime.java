package icu.bitchigo.ismybat.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对应开始时间注解
 *
 * @author bitchigo
 * @date 2022/09/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@DBFieldIgnore
public @interface DBStartTime {
    /**
     * 字段名
     *
     * @return {@link String}
     */
    String fieldName();
}
