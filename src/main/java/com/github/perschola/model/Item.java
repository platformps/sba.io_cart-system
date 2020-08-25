package com.github.perschola.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemName, item.itemName) &&
                Objects.equals(itemDescription, item.itemDescription) &&
                Objects.equals(itemPrice, item.itemPrice) &&
                Objects.equals(quantity, item.quantity) &&
                Objects.equals(availableQuantity, item.availableQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemDescription, itemPrice, quantity, availableQuantity);
    }
}
