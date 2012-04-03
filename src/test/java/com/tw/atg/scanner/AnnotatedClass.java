package com.tw.atg.scanner;

import com.tw.atg.annotation.ATGUIForm;
import com.tw.atg.annotation.ATGUIElement;

@ATGUIForm
public class AnnotatedClass {
	@ATGUIElement(label = "Message")
	public String message;

}
