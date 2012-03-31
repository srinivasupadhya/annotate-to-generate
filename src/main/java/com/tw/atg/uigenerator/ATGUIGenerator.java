package com.tw.atg.uigenerator;

import java.util.List;
import com.tw.atg.ui.UIElement;

public class ATGUIGenerator {
	public String generate(List<UIElement> uiElements) {
		StringBuilder result = new StringBuilder();
		result.append("<table>");
		for (int i = 0; i < uiElements.size(); i++) {
			result.append("<tr>");
			result.append("<td>");
			result.append(uiElements.get(i).getUiElementLabel());
			result.append("<td>");
			result.append("<td>");
			result.append("<input type=\"" + uiElements.get(i).getUiElementType() + "\" name=\"" + uiElements.get(i).getUiElementName() + "\" id=\""
					+ uiElements.get(i).getUiElementId() + "\" />");
			result.append("<td>");
			result.append("</tr>");
		}
		result.append("</table>");
		return result.toString();
	}
}
