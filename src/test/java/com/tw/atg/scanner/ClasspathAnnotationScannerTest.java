package com.tw.atg.scanner;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tw.atg.ui.UIForm;

/**
 * Unit test for ClasspathAnnotationScanner.
 */
public class ClasspathAnnotationScannerTest {
	@Test
	public void testScanForAnnotations() {
		UIForm uiForm = new ClasspathAnnotationScanner().scanForAnnotations(AnnotatedClass.class);
		assertEquals(uiForm.getUiElements().size(), 1);
	}
}
