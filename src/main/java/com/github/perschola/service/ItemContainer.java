package com.github.perschola.service;

import com.github.perschola.model.Item;
import com.github.perschola.model.ItemInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implemented by Monica Deshmukh
 * 08/15/2020
 */
/*public interface ItemContainer {
    Boolean checkAvailability(ItemInterface item);

    void add(ItemInterface item);

    void remove(ItemInterface item);

    void remove(String itemName);

    void display();

    ItemInterface get(String itemName);
}*/
public interface ItemContainer extends Iterable<ItemInterface> {
    List<ItemInterface> getItemList();

    default Boolean isAvailable(ItemInterface item) {
        if (item.getAvailableQuantity() > item.getQuantity())
            return true;
        else
            return false;
      /*  if (getItemList()
                .stream()
                .map(ItemInterface::getItemName)
                .collect(Collectors.toList())
                .contains(item.getItemName())) {
            Integer availableQuantity = item.getQuantity();
            return availableQuantity > 0;
        }
        return false;*/
    }

    default void add(ItemInterface item) {
        getItemList().add(item);
    }

    default void remove(ItemInterface item) {
        getItemList().remove(item);
    }

    default void remove(String itemName) {
        List<ItemInterface> itemsToBeRemoved = new ArrayList<>();
        for (ItemInterface item : getItemList()) {
            if (item.getItemName().equals(itemName)) {
                itemsToBeRemoved.add(item);
            }
        }
        getItemList().removeAll(itemsToBeRemoved);
    }

    default void display() {
        for (ItemInterface item : this) {
            System.out.println(item.toString());
        }
    }

    default ItemInterface get(String itemName) {
        if (getItemList() != null) {
            for (ItemInterface item : getItemList()) {
                if (item.getItemName().equals(itemName)) {
                    return item;
                }
            }
        }
        return null;
        /*if (getItemList() != null) {
            return getItemList()
                    .stream()
                    .filter(item -> item.getItemName().equals(itemName))
                    .findFirst().orElseGet(null);
                    //.get();
        } else return null;
        */

    }

    default Iterator iterator() {
        return getItemList().iterator();
    }
}
