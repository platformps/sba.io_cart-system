package com.github.perschola.service;

import com.github.perschola.model.ItemInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 6/11/2020.
 */

/**
 * Implemented by Monica Deshmukh
 * 08/15/2020
 */
public class ShoppingStoreService extends AbstractItemContainer {
    //add item to the shopping store inventory
    @Override
    public void add(ItemInterface item) {
        boolean isNewItem = true;
        for (ItemInterface storeItem : getItemList()) {
            if (item.getItemName().equals(storeItem.getItemName())) {
                isNewItem = false;
                addInventory(item.getItemName(), item.getAvailableQuantity());
            }
        }
            if (isNewItem)
                getItemList().add(item);    //add item to be sold in the cart
    }

    //remove item from the shopping store inventory
    @Override
    public void remove(ItemInterface item) {
        getItemList().remove(item); //remove item from the cart
        //item.setAvailableQuantity(item.getAvailableQuantity() - 1); //reduce the available quantity of the item by 1
    }

    //remove all items with name = itemName from the shopping store inventory
    @Override
    public void remove(String itemName) {
        List<ItemInterface> itemsToBeRemoved = new ArrayList<>();
        for (ItemInterface item : getItemList()) {
            if (item.getItemName().equals(itemName)) {
                itemsToBeRemoved.add(item);
                item.setAvailableQuantity(item.getAvailableQuantity() - 1); //reduce the available quantity of the item by 1
            }
        }
        getItemList().removeAll(itemsToBeRemoved);  //remove all items from the cart with name = itemName

    }

    public void addInventory(String itemName, Integer addtoAvailableQuantity) {
        for (ItemInterface item : getItemList()) {
            if (item.getItemName().equals(itemName)) {
                item.setAvailableQuantity(item.getAvailableQuantity() + addtoAvailableQuantity);
            }
        }
    }
}
