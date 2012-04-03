package com.tw.atg.ui;

import java.util.List;

public class UIForm {
	public String model;
	
	public List<UIElement> uiElements;

	public UIForm(String name, List<UIElement> uiElements) {
		this.uiElements = uiElements;
	}

	public List<UIElement> getUiElements() {
		return uiElements;
	}

}
