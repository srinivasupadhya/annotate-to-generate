package com.tw.atg.ui.generator;

import java.util.List;

import com.tw.atg.ui.model.UIElement;
import com.tw.atg.util.StringUtil;

public class ATGDefaultHTMLUIGenerator implements ATGUIGenerator {
	public static final String DISABLED_TRUE = " disabled=\"true\"", READ_ONLY_TRUE = " readonly=\"true\"";
	public static final String CHECKED_TRUE = " checked=\"checked\"", SELECTED_TRUE = " selected=\"selected\"";

	private String elementUINameAttribute, elementUIIdAttribute, elementUISize, elementUIMaxLength, elementUIWidth, elementUIHeight;
	private String elementUIDisabled, elementUIReadOnly, elementUIDefaultValue, elementUIValue, elementUIChecked, elementUISelected;
	private String[][] displayNameNValuePairs;

	public String generate(List<UIElement> uiElements) {
		StringBuilder result = new StringBuilder();

		result.append("<table>");
		for (int i = 0; i < uiElements.size(); i++) {
			UIElement currentUIElement = uiElements.get(i);

			result.append("<tr>");
			result.append("<td>");
			result.append(currentUIElement.getUiElementLabel());
			result.append("</td>");
			result.append("<td>");

			calculateUIElementAttributes(currentUIElement);

			generateUIElement(result, currentUIElement);

			result.append("</td>");
			result.append("</tr>");
		}
		result.append("</table>");
		return result.toString();
	}

	private void calculateUIElementAttributes(UIElement currentUIElement) {
		elementUINameAttribute = "";
		if (!StringUtil.isEmpty(currentUIElement.getUiElementName()))
			elementUINameAttribute = " name=\"" + currentUIElement.getUiElementName() + "\"";

		elementUIIdAttribute = "";
		if (!StringUtil.isEmpty(currentUIElement.getUiElementId()))
			elementUIIdAttribute = " id=\"" + currentUIElement.getUiElementId() + "\"";

		elementUISize = "";
		if (currentUIElement.getUiElementSize() >= 0)
			elementUISize = " size=\"" + currentUIElement.getUiElementSize() + "\"";

		elementUIMaxLength = "";
		if (currentUIElement.getUiElementMaxLength() >= 0)
			elementUIMaxLength = " maxlength=\"" + currentUIElement.getUiElementMaxLength() + "\"";

		elementUIWidth = "";
		if (currentUIElement.getUiElementWidth() >= 0)
			elementUIWidth = " col=\"" + currentUIElement.getUiElementWidth() + "\"";

		elementUIHeight = "";
		if (currentUIElement.getUiElementHeight() >= 0)
			elementUIHeight = " row=\"" + currentUIElement.getUiElementHeight() + "\"";

		displayNameNValuePairs = null;
		if (currentUIElement.getUiElementDisplayNameNValuePairs() != null)
			displayNameNValuePairs = currentUIElement.getUiElementDisplayNameNValuePairs();

		elementUIDisabled = "";
		if (currentUIElement.getUiElementIsDisabled())
			elementUIDisabled = DISABLED_TRUE;

		elementUIReadOnly = "";
		if (currentUIElement.getUiElementIsReadOnly())
			elementUIReadOnly = READ_ONLY_TRUE;

		elementUIDefaultValue = "";
		if (!StringUtil.isEmpty(currentUIElement.getUiElementDefaultValue()))
			elementUIDefaultValue = " value=\"" + currentUIElement.getUiElementDefaultValue() + "\"";
	}

	private void generateUIElement(StringBuilder result, UIElement currentUIElement) {
		switch (currentUIElement.getUiElementType()) {
		case CHECK_BOX:
			if (displayNameNValuePairs != null) {
				for (int j = 0; j < displayNameNValuePairs.length; j++) {
					elementUIValue = " value=\"" + displayNameNValuePairs[j][0] + "\"";
					result.append("<input" + " type=\"checkbox\"" + elementUINameAttribute + elementUIIdAttribute + elementUIValue + ">"
							+ displayNameNValuePairs[j][1] + "</input>");
				}
			}
			break;
		case RADIO_BUTTON:
			if (displayNameNValuePairs != null) {
				for (int j = 0; j < displayNameNValuePairs.length; j++) {
					elementUIValue = " value=\"" + displayNameNValuePairs[j][0] + "\"";
					elementUIChecked = "";
					if (displayNameNValuePairs[j][0].equals(elementUIDefaultValue))
						elementUIChecked = CHECKED_TRUE;
					result.append("<input" + " type=\"radio\"" + elementUINameAttribute + elementUIIdAttribute + elementUIValue + elementUIChecked
							+ elementUIDisabled + ">" + displayNameNValuePairs[j][1] + "</input>");
				}
			}
			break;
		case SELECT_BOX:
			if (displayNameNValuePairs != null) {
				result.append("<select" + elementUINameAttribute + elementUIIdAttribute + ">");
				for (int j = 0; j < displayNameNValuePairs.length; j++) {
					elementUIValue = " value=\"" + displayNameNValuePairs[j][0] + "\"";
					elementUISelected = "";
					if (displayNameNValuePairs[j][0].equals(elementUIDefaultValue))
						elementUISelected = SELECTED_TRUE;
					result.append("<option" + elementUIValue + elementUISelected + elementUIDisabled + ">" + displayNameNValuePairs[j][1] + "</option>");
				}
				result.append("</select>");
			}
			break;
		case TEXT_AREA:
			result.append("<textarea" + elementUINameAttribute + elementUIIdAttribute + elementUIWidth + elementUIHeight + elementUIDisabled
					+ elementUIReadOnly + ">" + currentUIElement.getUiElementDefaultValue() + "</textarea>");
			break;
		case PASSWORD_BOX:
			result.append("<input" + " type=\"password\"" + elementUINameAttribute + elementUIIdAttribute + elementUISize + elementUIMaxLength
					+ elementUIDisabled + elementUIReadOnly + elementUIDefaultValue + "/>");
		case TEXT_BOX:
		default:
			result.append("<input" + " type=\"text\"" + elementUINameAttribute + elementUIIdAttribute + elementUISize + elementUIMaxLength + elementUIDisabled
					+ elementUIReadOnly + elementUIDefaultValue + "/>");
		}
	}
}
