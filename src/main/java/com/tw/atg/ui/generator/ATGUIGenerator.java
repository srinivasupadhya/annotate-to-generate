package com.tw.atg.ui.generator;

import java.util.List;

import com.tw.atg.ui.model.UIElement;

public interface ATGUIGenerator {
	public String generate(List<UIElement> uiElements);
}
