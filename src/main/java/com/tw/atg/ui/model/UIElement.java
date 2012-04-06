package com.tw.atg.ui.model;

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

	private String[][] uiElementDisplayNameNValuePairs;
	private String uiElementDefaultValue;
	private int uiElementSize;
	private int uiElementMaxLength;
	private int uiElementWidth;
	private int uiElementHeight;
	private boolean uiElementIsDisabled;
	private boolean uiElementIsReadOnly;
	private boolean isRequired;

	public UIElement(String modelClass, ModelAttributeType modelAttributeType, String modelAttributeName, Object modelAttributeValue, String uiElementLabel,
			UIPosition uiElementLabelPosition, UIElementType uiElementType, String uiElementName, String uiElementId, UIPosition uiElementPosition,
			String[][] uiElementDisplayNameNValuePairs, String uiElementDefaultValue, int uiElementSize, int uiElementMaxLength, int uiElementWidth,
			int uiElementHeight, boolean uiElementIsDisabled, boolean uiElementIsReadOnly, boolean isRequired) {
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
		this.uiElementDisplayNameNValuePairs = uiElementDisplayNameNValuePairs;
		this.uiElementDefaultValue = uiElementDefaultValue;
		this.uiElementSize = uiElementSize;
		this.uiElementMaxLength = uiElementMaxLength;
		this.uiElementWidth = uiElementWidth;
		this.uiElementHeight = uiElementHeight;
		this.uiElementIsDisabled = uiElementIsDisabled;
		this.uiElementIsReadOnly = uiElementIsReadOnly;
		this.isRequired = isRequired;
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

	public String[][] getUiElementDisplayNameNValuePairs() {
		return uiElementDisplayNameNValuePairs;
	}

	public void setUiElementDisplayNameNValuePairs(String[][] uiElementDisplayNameNValuePairs) {
		this.uiElementDisplayNameNValuePairs = uiElementDisplayNameNValuePairs;
	}

	public String getUiElementDefaultValue() {
		return uiElementDefaultValue;
	}

	public void setUiElementDefaultValue(String uiElementDefaultValue) {
		this.uiElementDefaultValue = uiElementDefaultValue;
	}

	public int getUiElementSize() {
		return uiElementSize;
	}

	public void setUiElementSize(int uiElementSize) {
		this.uiElementSize = uiElementSize;
	}

	public int getUiElementMaxLength() {
		return uiElementMaxLength;
	}

	public void setUiElementMaxLength(int uiElementMaxLength) {
		this.uiElementMaxLength = uiElementMaxLength;
	}

	public int getUiElementWidth() {
		return uiElementWidth;
	}

	public void setUiElementWidth(int uiElementWidth) {
		this.uiElementWidth = uiElementWidth;
	}

	public int getUiElementHeight() {
		return uiElementHeight;
	}

	public void setUiElementHeight(int uiElementHeight) {
		this.uiElementHeight = uiElementHeight;
	}

	public boolean getUiElementIsDisabled() {
		return uiElementIsDisabled;
	}

	public void setUiElementIsDisabled(boolean uiElementIsDisabled) {
		this.uiElementIsDisabled = uiElementIsDisabled;
	}

	public boolean getUiElementIsReadOnly() {
		return uiElementIsReadOnly;
	}

	public void setUiElementIsReadOnly(boolean uiElementIsReadOnly) {
		this.uiElementIsReadOnly = uiElementIsReadOnly;
	}

	public boolean getRequired() {
		return isRequired;
	}

	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}
}
