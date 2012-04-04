package com.tw.atg.scanner;

import com.tw.atg.annotation.ATGForm;
import com.tw.atg.annotation.ATGTextArea;
import com.tw.atg.annotation.ATGTextBox;

@ATGForm
public class AnnotatedClass {
	@ATGTextBox(label = "Message")
	public String message;

	@ATGTextArea(label = "Test")
	public String test;

}
