package jaysan.wildfly.gestion.wildflygestion.pub.dto;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Product {
	private String code;
	private String name;
	private String line;
	private String scale;
	private String vendor;
	private String description;
	private Integer quantityInStock;
	private Double buyPrice;
	private Double msrp;
	
	public Product() {
	}
	
	public Product(
			String code, String name, String line,
			String scale, String vendor, String description,
			Integer quantityInStock, Double buyPrice, Double msrp) {
		this.code = code;
		this.name = name;
		this.line = line;
		this.scale = scale;
		this.vendor = vendor;
		this.description = description;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLine() {
		return line;
	}
	
	public void setLine(String line) {
		this.line = line;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Double getMsrp() {
		return msrp;
	}

	public void setMsrp(Double msrp) {
		this.msrp = msrp;
	}
	
	public String toString() {
		return "Product[" + Arrays.stream(new String[] {code, name, line}).collect(Collectors.joining(",")) + "]";
	}
}
