package com.github.perschola.itemcontainerinterface;

import com.github.perschola.model.ItemInterface;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public interface ItemContainerInterface {
    default Boolean checkAvailability(ItemInterface item) {
        return getByName(item.getItemName()) != null;
    }

    default void add(ItemInterface item) {
        getList().add(item);
    }

    default void removeByItem(ItemInterface item) {
        getList().removeAll(
                getList()
                        .stream()
                        .filter(itemInList -> Objects.equals(itemInList.getItemName(), item.getItemName()))
                        .collect(Collectors.toList()));
    }

    default void removeByName(String itemName) {
        getList().remove(getByName(itemName));
    }

    default void display() {
        System.out.println(this.toString());
    }

    default ItemInterface getByName(String itemName) {
        return getList()
                .stream()
                .filter(itemInList -> Objects.equals(itemInList.getItemName(), itemName))
                .findFirst()
                .get();
    }

    List<ItemInterface> getList();
}
