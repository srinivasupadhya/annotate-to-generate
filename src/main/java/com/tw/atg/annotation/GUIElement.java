package com.tw.atg.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.tw.atg.constant.UIElementType;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GUIElement {
	boolean nullable() default false;

	String label() default "";

	int labelRow() default -1;

	int labelColumn() default -1;

	UIElementType uiElementType() default UIElementType.TEXT_BOX;

	int row() default -1;

	int column() default -1;
}
