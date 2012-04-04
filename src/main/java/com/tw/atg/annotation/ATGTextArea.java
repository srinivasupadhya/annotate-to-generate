package com.tw.atg.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ATGTextArea {
	String label();

	int labelRow() default -1;

	int labelColumn() default -1;

	int row() default -1;

	int column() default -1;

	String defaultValue() default "";

	int width() default -1;

	int height() default -1;

	boolean isDisabled() default false;

	boolean isReadOnly() default false;
}
