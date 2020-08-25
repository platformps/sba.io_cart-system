package com.github.perschola.model;

/**
 * Created by leon on 8/24/2020.
 */

public class ItemBuilder {
    private String itemName;
    private String itemDescription;
    private Double itemPrice;
    private Integer quantity;
    private Integer availableQuantity;

    public ItemBuilder setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public ItemBuilder setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
        return this;
    }

    public ItemBuilder setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
        return this;
    }

    public ItemBuilder setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public ItemBuilder setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
        return this;
    }

    public ItemInterface build() {
        ItemInterface item = (ItemInterface)new Item();
        item.setAvailableQuantity(availableQuantity);
        item.setQuantity(quantity);
        item.setItemDescription(itemDescription);
        item.setItemPrice(itemPrice);
        item.setItemName(itemName);
        return item;
    }
}