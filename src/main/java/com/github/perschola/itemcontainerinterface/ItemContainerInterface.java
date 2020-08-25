package com.github.perschola.itemcontainerinterface;

import com.github.perschola.model.ItemInterface;

import java.util.List;

public interface ItemContainerInterface {
    Boolean checkAvailability(ItemInterface item);

    void add(ItemInterface item);

    void removeByItem(ItemInterface item);

    void removeByName(String itemName);

    void display();

    ItemInterface getByName(String itemName);

    List<ItemInterface> getList();
}
