package com.tw.atg.scanner;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.tw.atg.scanner.ClasspathAnnotationScanner;
import com.tw.atg.ui.UIElement;

/**
 * Unit test for ClasspathAnnotationScanner.
 */
public class ClasspathAnnotationScannerTest {
	@Test
	public void testScanForAnnotations() {
		List<UIElement> uiElements = new ClasspathAnnotationScanner().scanForAnnotations(AnnotatedClass.class);
		assertEquals(uiElements.size(), 1);
	}
}
