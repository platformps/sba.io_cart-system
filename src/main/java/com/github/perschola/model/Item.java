package com.github.perschola.model;

public class Item implements ItemInterface {
    private String itemName;
    private String itemDescription;
    private Double itemPrice;
    private Integer quantity;
    private Integer availableQuantity;

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String getItemDescription() {
        return itemDescription;
    }

    @Override
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Override
    public Double getItemPrice() {
        return itemPrice;
    }

    @Override
    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    @Override
    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
    @Override
    public String toString() {
        return String.format("%-20s %-20s %-10.2f %-10d\n",
                this.getItemName(),
                this.getItemDescription(),
                this.getItemPrice(),
                this.getAvailableQuantity());
    }
}
