package com.github.perschola.model;

/**
 * Implemented by Monica Deshmukh
 * 8/14/2020
 */
public class Item implements ItemInterface{

    private String  itemName;	        //Name of the item
    private String	itemDesc;	        //Contains the item's description
    private Double	itemPrice;	        //Contains a double value which represents the item’s price
    private Integer	quantity = 0;	        //Represents the number of items the user has added to the cart
    private Integer	availableQuantity = 0;	//Represents the number of items available in the system

    //Nullary Constructor
    public Item() {
        this(null, null, 0D, 0, 0);
    }
    public Item(String itemName, String itemDesc, Double itemPrice){
        this(itemName, itemDesc, itemPrice, 0, 0);
    }

   public Item(String itemName, String itemDesc, Double itemPrice, Integer quantity, Integer availableQuantity) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.availableQuantity = availableQuantity;
    }
    @Override
    public String getItemName() {
        return this.itemName;
    }

    @Override
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String getItemDesc() {
        return this.itemDesc;
    }

    @Override
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    @Override
    public Double getItemPrice() {
        return this.itemPrice;
    }

    @Override
    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public Integer getQuantity() {
        return this.quantity;
    }

    @Override
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        //setAvailableQuantity(getAvailableQuantity() - quantity);
    }

    @Override
    public Integer getAvailableQuantity() {
        return this.availableQuantity;
    }

    @Override
    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", itemPrice=" + itemPrice +
                ", quantity=" + quantity +
                ", availableQuantity=" + availableQuantity +
                '}';
    }
}
