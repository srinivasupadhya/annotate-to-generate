package com.tw.atg.scanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.tw.atg.annotation.ATGCheckBox;
import com.tw.atg.annotation.ATGPasswordBox;
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
	private UIForm uiForm = null;
	private List<UIElement> uiElements = new ArrayList<UIElement>();
	private boolean autoLayout = true;

	private UIElementType uiElementType;
	private String uiElementLabel;
	private UIPosition uiElementLabelPosition;
	private String uiElementName, uiElementId;
	private UIPosition uiElementPosition;

	public UIForm scanForAnnotations(Class<?> inputClass) {
		ATGForm classAnnotation = inputClass.getAnnotation(ATGForm.class);
		if (classAnnotation == null) {
			return uiForm;
		}

		Field[] fields = inputClass.getDeclaredFields();

		for (Field currentField : fields) {
			initialize();

			Annotation[] fieldAnnotations = currentField.getAnnotations();

			if (fieldAnnotations == null || fieldAnnotations.length == 0)
				continue; // no annotations, skip to next field

			for (Annotation currentFieldAnnotation : fieldAnnotations) {
				findUIElementType(currentFieldAnnotation);

				if (uiElementType == null)
					continue; // not interested in the annotation, skip to next

				// Model details
				String modelClass = inputClass.getName();
				ModelAttributeType modelAttributeType = null;
				String modelAttributeName = currentField.getName();
				Object modelAttributeValue = null;

				readAnnotationAttributes(currentField, currentFieldAnnotation);

				UIElement uiElement = new UIElement(modelClass, modelAttributeType, modelAttributeName, modelAttributeValue, uiElementLabel,
						uiElementLabelPosition, uiElementType, uiElementName, uiElementId, uiElementPosition);
				uiElements.add(uiElement);

				break; // not interested in rest of the annotations of field
			}
		}

		calculateLayout();

		uiForm = new UIForm(inputClass.getName(), uiElements);

		return uiForm;
	}

	private void initialize() {
		uiElementType = null;
		uiElementLabel = null;
		uiElementLabelPosition = null;
		uiElementName = null;
		uiElementId = null;
		uiElementPosition = null;
	}

	private void findUIElementType(Annotation currentFieldAnnotation) {
		uiElementType = null;
		if (currentFieldAnnotation instanceof ATGTextBox)
			uiElementType = UIElementType.TEXT_BOX;
		else if (currentFieldAnnotation instanceof ATGPasswordBox)
			uiElementType = UIElementType.PASSWORD_BOX;
		else if (currentFieldAnnotation instanceof ATGTextArea)
			uiElementType = UIElementType.TEXT_AREA;
		else if (currentFieldAnnotation instanceof ATGRadioButton)
			uiElementType = UIElementType.RADIO_BUTTON;
		else if (currentFieldAnnotation instanceof ATGCheckBox)
			uiElementType = UIElementType.CHECK_BOX;
		else if (currentFieldAnnotation instanceof ATGSelectBox)
			uiElementType = UIElementType.SELECT_BOX;
	}

	private void readAnnotationAttributes(Field currentField, Annotation currentFieldAnnotation) {
		switch (uiElementType) {
		case TEXT_BOX:
			readATGTextBox((ATGTextBox) currentFieldAnnotation, currentField);
			break;
		case PASSWORD_BOX:
			readATGTextBox((ATGTextBox) currentFieldAnnotation, currentField);
			break;
		case TEXT_AREA:
			readATGTextBox((ATGTextBox) currentFieldAnnotation, currentField);
			break;
		case RADIO_BUTTON:
			readATGTextBox((ATGTextBox) currentFieldAnnotation, currentField);
			break;
		case CHECK_BOX:
			readATGTextBox((ATGTextBox) currentFieldAnnotation, currentField);
			break;
		case SELECT_BOX:
			readATGTextBox((ATGTextBox) currentFieldAnnotation, currentField);
			break;
		}
	}

	private void readATGTextBox(ATGTextBox elementAnnotation, Field field) {
		uiElementLabel = field.getName();
		if (elementAnnotation.label() != null && !elementAnnotation.label().trim().isEmpty())
			uiElementLabel = elementAnnotation.label();
		uiElementLabelPosition = new UIPosition(0, 0);
		if (elementAnnotation.labelRow() >= 0 && elementAnnotation.labelColumn() >= 0) {
			uiElementLabelPosition = new UIPosition(elementAnnotation.labelRow(), elementAnnotation.labelColumn());
			autoLayout = false;
		}

		uiElementPosition = new UIPosition(0, 0);
		if (elementAnnotation.row() >= 0 && elementAnnotation.column() >= 0) {
			uiElementLabelPosition = new UIPosition(elementAnnotation.row(), elementAnnotation.column());
			autoLayout = false;
		}
	}

	private void calculateLayout() {
		if (autoLayout) {
			int count = 0;
			for (UIElement currentUIElement : uiElements) {
				currentUIElement.setUiElementLabelPosition(new UIPosition(count, 0));
				currentUIElement.setUiElementPosition(new UIPosition(count, 1));
				count++;
			}
		}
	}
}
