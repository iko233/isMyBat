package icu.bitchigo.ismybat.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标注为数据库映射实体类
 *
 * @author bitchigo
 * @date 2022/09/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DBTable {
    /**
     * 名称
     *
     * @return {@link String}
     */
    String name();
}
