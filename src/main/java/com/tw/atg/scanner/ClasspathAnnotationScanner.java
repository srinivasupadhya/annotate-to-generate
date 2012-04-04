package com.tw.atg.scanner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.tw.atg.annotation.ATGCheckBox;
import com.tw.atg.annotation.ATGRadioButton;
import com.tw.atg.annotation.ATGSelectBox;
import com.tw.atg.annotation.ATGTextArea;
import com.tw.atg.annotation.ATGTextBox;
import com.tw.atg.annotation.ATGForm;
import com.tw.atg.constant.ModelAttributeType;
import com.tw.atg.constant.UIElementType;
import com.tw.atg.ui.UIElement;
import com.tw.atg.ui.UIForm;
import com.tw.atg.ui.UIPosition;

/**
 * @understands: How to scan classes annotated for ATG UI generation
 */
public class ClasspathAnnotationScanner {
	public UIForm scanForAnnotations(Class<?> inputClass) {
		UIForm uiForm = null;
		List<UIElement> uiElements = new ArrayList<UIElement>();
		Field[] fields = inputClass.getDeclaredFields();

		ATGForm formAnnotation = inputClass.getAnnotation(ATGForm.class);
		if (formAnnotation == null) {
			return uiForm;
		}

		boolean autoLayout = true;

		for (Field currentField : fields) {
			ATGTextBox elementAnnotation = currentField.getAnnotation(ATGTextBox.class);

			// Model details
			String modelClass = inputClass.getName();
			ModelAttributeType modelAttributeType = null;
			String modelAttributeName = currentField.getName();
			Object modelAttributeValue = null;
			// UIElement label details
			String uiElementLabel = currentField.getName();
			if (elementAnnotation.label() != null && !elementAnnotation.label().trim().isEmpty())
				uiElementLabel = elementAnnotation.label();
			UIPosition uiElementLabelPosition = new UIPosition(0, 0);
			if (elementAnnotation.labelRow() >= 0 && elementAnnotation.labelColumn() >= 0) {
				uiElementLabelPosition = new UIPosition(elementAnnotation.labelRow(), elementAnnotation.labelColumn());
				autoLayout = false;
			}
			// UIElement details
			UIElementType uiElementType = UIElementType.TEXT_BOX;
			if (elementAnnotation.equals(ATGTextArea.class))
				uiElementType = UIElementType.TEXT_AREA;
			else if (elementAnnotation.equals(ATGRadioButton.class))
				uiElementType = UIElementType.RADIO_BUTTON;
			else if (elementAnnotation.equals(ATGCheckBox.class))
				uiElementType = UIElementType.CHECK_BOX;
			else if (elementAnnotation.equals(ATGSelectBox.class))
				uiElementType = UIElementType.SELECT_BOX;

			String uiElementName = null;
			String uiElementId = null;
			UIPosition uiElementPosition = new UIPosition(0, 0);
			if (elementAnnotation.row() >= 0 && elementAnnotation.column() >= 0) {
				uiElementLabelPosition = new UIPosition(elementAnnotation.row(), elementAnnotation.column());
				autoLayout = false;
			}

			if (elementAnnotation != null) {
				UIElement uiElement = new UIElement(modelClass, modelAttributeType, modelAttributeName, modelAttributeValue, uiElementLabel,
						uiElementLabelPosition, uiElementType, uiElementName, uiElementId, uiElementPosition);
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

		uiForm = new UIForm(inputClass.getName(), uiElements);

		return uiForm;
	}
}
