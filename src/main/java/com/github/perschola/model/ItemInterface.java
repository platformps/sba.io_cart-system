package com.github.perschola.model;

public interface ItemInterface {
    String getItemName();

    void setItemName(String itemName);

    String getItemDescription();

    void setItemDescription(String itemDesc);

    Double getItemPrice();

    void setItemPrice(Double itemPrice);

    Integer getQuantity();

    void setQuantity(Integer quantity);

    Integer getAvailableQuantity();

    void setAvailableQuantity(Integer availableQuantity);
}
