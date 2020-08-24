package com.github.perschola.service;

import com.github.perschola.model.ItemInterface;

public interface ItemContainerInterface {
    Boolean checkAvailability(ItemInterface item);

    void add(ItemInterface item);

    void removeByItem(ItemInterface item);

    void removeByName(String itemName);

    void display();

    ItemInterface getByName(String itemName);
}
