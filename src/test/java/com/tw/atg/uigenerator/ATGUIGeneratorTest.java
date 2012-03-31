package com.tw.atg.uigenerator;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.tw.atg.scanner.AnnotatedClass;
import com.tw.atg.scanner.ClasspathAnnotationScanner;
import com.tw.atg.ui.UIElement;

public class ATGUIGeneratorTest {
	@Test
	public void testScanForAnnotations() {
		List<UIElement> uiElements = new ClasspathAnnotationScanner().scanForAnnotations(AnnotatedClass.class);
		assertEquals(uiElements.size(), 1);
		System.out.println(new ATGUIGenerator().generate(uiElements));
	}
}
