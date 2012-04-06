package com.tw.atg.uigenerator;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import org.junit.Test;

import com.tw.atg.scanner.AnnotatedClass;
import com.tw.atg.scanner.ClasspathAnnotationScanner;
import com.tw.atg.ui.generator.ATGDefaultHTMLUIGenerator;
import com.tw.atg.ui.model.UIElement;
import com.tw.atg.ui.model.UIForm;

public class ATGUIGeneratorTest {
	@Test
	public void testScanForAnnotations() {
		UIForm uiForm = new ClasspathAnnotationScanner().scanForAnnotations(AnnotatedClass.class);
		List<UIElement> uiElements = uiForm.getUiElements();
		assertEquals(uiElements.size(), 2);
		String generatedHTML = new ATGDefaultHTMLUIGenerator().generate(uiElements);
		System.out.println(generatedHTML);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("/tmp/generated.html"));
			writer.write(generatedHTML);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
