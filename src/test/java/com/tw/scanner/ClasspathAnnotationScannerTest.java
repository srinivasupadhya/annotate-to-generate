package com.tw.scanner;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for ClasspathAnnotationScanner.
 */
public class ClasspathAnnotationScannerTest {
	@Test
	public void testScanForAnnotations() {
		assertEquals(new ClasspathAnnotationScanner().scanForAnnotations(), 0);
	}
}
