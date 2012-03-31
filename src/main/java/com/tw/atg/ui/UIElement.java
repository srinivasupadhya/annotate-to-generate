package com.tw.atg.ui;

import com.tw.atg.constant.ModelAttributeType;
import com.tw.atg.constant.UIElementType;

public class UIElement {
	// Model Details
	private String modelClass;
	private ModelAttributeType modelAttributeType;
	private String modelAttributeName;
	private Object modelAttributeValue;

	// UI Element Details
	private String uiElementLabel;
	private UIPosition uiElementLabelPosition;

	private UIElementType uiElementType;
	private String uiElementName;
	private String uiElementId;
	private UIPosition uiElementPosition;

	public UIElement(String modelClass, ModelAttributeType modelAttributeType, String modelAttributeName, Object modelAttributeValue, String uiElementLabel,
			UIPosition uiElementLabelPosition, UIElementType uiElementType, String uiElementName, String uiElementId, UIPosition uiElementPosition) {
		super();
		this.modelClass = modelClass;
		this.modelAttributeType = modelAttributeType;
		this.modelAttributeName = modelAttributeName;
		this.modelAttributeValue = modelAttributeValue;
		this.uiElementLabel = uiElementLabel;
		this.uiElementLabelPosition = uiElementLabelPosition;
		this.uiElementType = uiElementType;
		this.uiElementName = uiElementName;
		this.uiElementId = uiElementId;
		this.uiElementPosition = uiElementPosition;
	}

	public String getModelClass() {
		return modelClass;
	}

	public void setModelClass(String modelClass) {
		this.modelClass = modelClass;
	}

	public ModelAttributeType getModelAttributeType() {
		return modelAttributeType;
	}

	public void setModelAttributeType(ModelAttributeType modelAttributeType) {
		this.modelAttributeType = modelAttributeType;
	}

	public String getModelAttributeName() {
		return modelAttributeName;
	}

	public void setModelAttributeName(String modelAttributeName) {
		this.modelAttributeName = modelAttributeName;
	}

	public Object getModelAttributeValue() {
		return modelAttributeValue;
	}

	public void setModelAttributeValue(Object modelAttributeValue) {
		this.modelAttributeValue = modelAttributeValue;
	}

	public String getUiElementLabel() {
		return uiElementLabel;
	}

	public void setUiElementLabel(String uiElementLabel) {
		this.uiElementLabel = uiElementLabel;
	}

	public UIPosition getUiElementLabelPosition() {
		return uiElementLabelPosition;
	}

	public void setUiElementLabelPosition(UIPosition uiElementLabelPosition) {
		this.uiElementLabelPosition = uiElementLabelPosition;
	}

	public UIElementType getUiElementType() {
		return uiElementType;
	}

	public void setUiElementType(UIElementType uiElementType) {
		this.uiElementType = uiElementType;
	}

	public String getUiElementName() {
		return uiElementName;
	}

	public void setUiElementName(String uiElementName) {
		this.uiElementName = uiElementName;
	}

	public String getUiElementId() {
		return uiElementId;
	}

	public void setUiElementId(String uiElementId) {
		this.uiElementId = uiElementId;
	}

	public UIPosition getUiElementPosition() {
		return uiElementPosition;
	}

	public void setUiElementPosition(UIPosition uiElementPosition) {
		this.uiElementPosition = uiElementPosition;
	}
}
