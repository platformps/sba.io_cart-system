package com.github.perschola.service;

import com.github.perschola.model.ItemInterface;

public interface ItemContainer {
    Boolean checkAvailability(ItemInterface item);

    void add(ItemInterface item);

    void remove(ItemInterface item);

    void remove(String itemName);

    void display();

    ItemInterface get(String itemName);
}
