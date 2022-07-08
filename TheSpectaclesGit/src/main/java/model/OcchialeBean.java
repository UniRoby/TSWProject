package model;

import java.io.Serializable;

public class OcchialeBean implements Serializable  {
	
	private static final long serialVersionUID = -4959563723922476262L;
	String idGlasses;
	String nameGlasses;
	String brand;
	int price;
	int availability;
	char type;
	String color;
    String category;
	String image;
	String image2;
	String description;
	int quantity=1;
	float totalPrice;
	
	public OcchialeBean() {
		quantity=1;
		totalPrice=0;
	}

	public OcchialeBean(String idGlasses, String nameGlasses, String brand, int price, int availability, char type,
			String color, String category, String image,String image2, String description) {
		super();
		this.idGlasses = idGlasses;
		this.nameGlasses = nameGlasses;
		this.brand = brand;
		this.price = price;
		this.availability = availability;
		this.type = type;
		this.color = color;
		this.category = category;
		this.image = image;
		this.image2 = image2;
		this.description = description;
	}

	public String getIdGlasses() {
		return idGlasses;
	}

	public void setIdGlasses(String idGlasses) {
		this.idGlasses = idGlasses;
	}

	public String getNameGlasses() {
		return nameGlasses;
	}

	public void setNameGlasses(String nameGlasses) {
		this.nameGlasses = nameGlasses;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity (int q) {
	this.quantity= q ;
	}
	
	public float getTotPrezzo() {
		return totalPrice;
	}
	
	public void setTotPrezzo(float prezzotot) {
		this.totalPrice = prezzotot;
	}

	public String toString() {
		return "OcchialeBean [idGlasses=" + idGlasses + ", nameGlasses=" + nameGlasses + ", brand=" + brand + ", price="
				+ price + ", availability=" + availability + ", type=" + type + ", color=" + color + ", idCategory="
				+ category + ", image=" + image + ", image2= " + image2 + ", description=" + description + "]";
	}
	
}
