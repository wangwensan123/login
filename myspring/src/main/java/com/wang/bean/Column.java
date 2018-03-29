package com.wang.bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.wang.util.X;

// TODO: Auto-generated Javadoc
/**
 * the {@code Field} Class used to annotate the Bean, define the
 * collection/table mapping with the Bean
 * 
 * 
 * @author joe
 *
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

  /**
   * the column name.
   *
   * @return String
   */
  String name() default X.EMPTY;

  /**
   * is Index field.
   *
   * @return true, if successful
   */
  boolean index() default false;

  /**
   * is Unique column.
   *
   * @return true, if successful
   */
  boolean unique() default false;

}
