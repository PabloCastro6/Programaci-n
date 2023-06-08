package com.Pablo.classicmodels.dtos;

public class InventarioDTO {
	private String productCode;
	private String productName;
	private String productLine;
	private String productDescription;
	private String productScale;
	private String productVendor; 
	private Integer quantityInStock;
	private Double buyPrice;
	private Double msrp;

	public InventarioDTO(String productCode, String productName, String productLine, String productDescription,
			String productScale, String productVendor, Integer quantityInStock, Double buyPrice, Double msrp) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productDescription = productDescription;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
	}

	public InventarioDTO() {
		super();
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductScale() {
		return productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public Integer getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Double getMSRP() {
		return msrp;
	}

	public void setMSRP(Double msrp) {
		msrp = msrp;
	}

	@Override
	public String toString() {
		return "InventarioDTO [productCode=" + productCode + ", productName=" + productName + ", productLine="
				+ productLine + ", productDescription=" + productDescription + ", productScale=" + productScale
				+ ", productVendor=" + productVendor + ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice
				+ ", MSRP=" + msrp + "]";
	}

	
}

