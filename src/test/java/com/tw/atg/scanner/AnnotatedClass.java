package com.tw.atg.scanner;

import com.tw.atg.annotation.GUIElement;
import com.tw.atg.model.ATGForm;

public class AnnotatedClass implements ATGForm {
	@GUIElement(label = "Message")
	public String message;

}
