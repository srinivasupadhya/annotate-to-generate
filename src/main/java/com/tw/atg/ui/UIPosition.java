package com.tw.atg.ui;

public class UIPosition {
	private Integer row, column;

	public UIPosition(Integer row, Integer column) {
		super();
		this.row = row;
		this.column = column;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that)
			return true;
		if (that == null || this.getClass() != that.getClass())
			return false;
		if (this.row == ((UIPosition) that).row && this.column == ((UIPosition) that).column)
			return true;
		return false;
	}
}
