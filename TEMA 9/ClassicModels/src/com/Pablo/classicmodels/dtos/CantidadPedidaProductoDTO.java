package com.Pablo.classicmodels.dtos;

public class CantidadPedidaProductoDTO {
	private String productCode;
	private Integer quantityOrdered;
	
	public CantidadPedidaProductoDTO(String productCode, Integer quantityOrdered) {
		super();
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
	}
	
	public CantidadPedidaProductoDTO() {
		super();
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	@Override
	public String toString() {
		return "CantidadPedidaProductoDTO [productCode=" + productCode + ", quantityOrdered=" + quantityOrdered + "]";
	}
	
	
}
	
	
	

