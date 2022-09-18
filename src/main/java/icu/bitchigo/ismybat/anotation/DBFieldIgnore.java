package icu.bitchigo.ismybat.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 忽略实体类与数据库映射关系注解
 *
 * @author bitchigo
 * @date 2022/09/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface DBFieldIgnore {
}
