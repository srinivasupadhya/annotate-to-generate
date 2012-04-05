package com.tw.atg.uigenerator;

import java.util.List;

import com.tw.atg.ui.UIElement;
import com.tw.atg.util.StringUtil;

public class ATGUIGenerator {
	public String generate(List<UIElement> uiElements) {
		StringBuilder result = new StringBuilder();

		String elementUINameAttribute, elementUIIdAttribute;

		result.append("<table>");
		for (int i = 0; i < uiElements.size(); i++) {
			UIElement currentUIElement = uiElements.get(i);

			result.append("<tr>");
			result.append("<td>");
			result.append(currentUIElement.getUiElementLabel());
			result.append("</td>");
			result.append("<td>");

			elementUINameAttribute = "";
			if (!StringUtil.isEmpty(currentUIElement.getUiElementName()))
				elementUINameAttribute = " name=\"" + currentUIElement.getUiElementName() + "\" ";

			elementUIIdAttribute = "";
			if (!StringUtil.isEmpty(currentUIElement.getUiElementId()))
				elementUIIdAttribute = " id=\"" + currentUIElement.getUiElementId() + "\" ";

			switch (currentUIElement.getUiElementType()) {
			case CHECK_BOX:
				result.append("<input" + " type=\"checkbox\" " + elementUINameAttribute + elementUIIdAttribute + "/>");
				break;
			case RADIO_BUTTON:
				result.append("<input" + " type=\"radio\" " + elementUINameAttribute + elementUIIdAttribute + "/>");
				break;
			case SELECT_BOX:
				result.append("<select" + elementUINameAttribute + elementUIIdAttribute + ">" + "</select>");
				break;
			case TEXT_AREA:
				result.append("<textarea" + elementUINameAttribute + elementUIIdAttribute + "></textarea>");
				break;
			case TEXT_BOX:
			default:
				result.append("<input" + " type=\"text\" " + elementUINameAttribute + elementUIIdAttribute + "/>");
			}
			result.append("</td>");
			result.append("</tr>");
		}
		result.append("</table>");
		return result.toString();
	}
}
