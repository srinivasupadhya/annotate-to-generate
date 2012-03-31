package com.tw.atg.scanner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.tw.atg.annotation.GUIElement;
import com.tw.atg.constant.ModelAttributeType;
import com.tw.atg.constant.UIElementType;
import com.tw.atg.model.ATGForm;
import com.tw.atg.ui.UIElement;
import com.tw.atg.ui.UIPosition;

/**
 * @understands: How to scan classes annotated for ATG UI generation
 */
public class ClasspathAnnotationScanner {
	public List<UIElement> scanForAnnotations(Class<? extends ATGForm> inputClass) {
		List<UIElement> uiElements = new ArrayList<UIElement>();
		Field[] fields = inputClass.getDeclaredFields();

		boolean autoLayout = true;

		for (Field currentField : fields) {
			GUIElement annotation = currentField.getAnnotation(GUIElement.class);

			// Model details
			String modelClass = inputClass.getName();
			ModelAttributeType modelAttributeType = null;
			String modelAttributeName = currentField.getName();
			Object modelAttributeValue = null;
			// UIElement label details
			String uiElementLabel = currentField.getName();
			if (annotation.label() != null && !annotation.label().trim().isEmpty())
				uiElementLabel = annotation.label();
			UIPosition uiElementLabelPosition = new UIPosition(0, 0);
			if (annotation.labelRow() >= 0 && annotation.labelColumn() >= 0) {
				uiElementLabelPosition = new UIPosition(annotation.labelRow(), annotation.labelColumn());
				autoLayout = false;
			}
			// UIElement details
			UIElementType uiElementType = annotation.uiElementType();
			String uiElementName = null;
			String uiElementId = null;
			UIPosition uiElementPosition = new UIPosition(0, 0);
			if (annotation.row() >= 0 && annotation.column() >= 0) {
				uiElementLabelPosition = new UIPosition(annotation.row(), annotation.column());
				autoLayout = false;
			}

			if (annotation != null) {
				UIElement uiElement = new UIElement(modelClass, modelAttributeType, modelAttributeName, modelAttributeValue, uiElementLabel, uiElementLabelPosition,
						uiElementType, uiElementName, uiElementId, uiElementPosition);
				uiElements.add(uiElement);
			}
		}

		if (autoLayout) {
			int count = 0;
			for (UIElement currentUIElement : uiElements) {
				currentUIElement.setUiElementLabelPosition(new UIPosition(count, 0));
				currentUIElement.setUiElementPosition(new UIPosition(count, 1));
				count++;
			}
		}

		return uiElements;
	}
}
