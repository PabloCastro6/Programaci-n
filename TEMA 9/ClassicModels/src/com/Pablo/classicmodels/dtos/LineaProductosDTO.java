package com.Pablo.classicmodels.dtos;

public class LineaProductosDTO {
	private String productLine;
	private String textDescription;
	
	
	public LineaProductosDTO(String productLine, String textDescription) {
		super();
		this.productLine = productLine;
		this.textDescription = textDescription;
	}

	public LineaProductosDTO() {
		super();
	}

	
	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	
	@Override
	public String toString() {
		return "LineaProductosDTO [productLine=" + productLine + ", textDescription=" + textDescription + "]";
	}
}

