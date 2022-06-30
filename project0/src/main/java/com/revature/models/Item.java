package com.revature.models;

import java.util.Objects;

public class Item {
	private String itemNumber;
	private String itemName;
	private float itemPrice;
	private String itemCategory;
	private String itemModel;
	private int itemQuantity;
	
	public Item() {
		super();


	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemModel() {
		return itemModel;
	}

	public void setItemModel(String itemModel) {
		this.itemModel = itemModel;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "Item [itemNumber = "+ itemNumber +", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", itemCategory=" + itemCategory + ", itemModel=" + itemModel + ", itemQuantity=" + itemQuantity
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemCategory, itemModel, itemName, itemNumber, itemPrice, itemQuantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(itemCategory, other.itemCategory) && Objects.equals(itemModel, other.itemModel)
				&& Objects.equals(itemName, other.itemName) && Objects.equals(itemNumber, other.itemNumber)
				&& Float.floatToIntBits(itemPrice) == Float.floatToIntBits(other.itemPrice)
				&& itemQuantity == other.itemQuantity;
	}
	
	
	
	

	

}
