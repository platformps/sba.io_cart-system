package com.github.perschola.service;

import com.github.perschola.model.ItemInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Implemented by Monica Deshmukh
 * 08/14/2020
 */
public class ShoppingCartService extends AbstractItemContainer {

    //add item to the shopping cart
    @Override
    public void add(ItemInterface item) {
        //add item to the shopping cart provided enough quantity of that item is available in the system.
        if(this.isAvailable(item)){
        //if (item.getAvailableQuantity() > item.getQuantity()) {
            getItemList().add(item);    //add item to be sold in the cart
            item.setQuantity(item.getQuantity() + 1); //increase the quantity of items in the cart by 1
            item.setAvailableQuantity(item.getAvailableQuantity() - 1); //reduce the available quantity of the item by 1
        }
        else
            System.out.println("cannot add this item to the cart. There is not enough inventory in the system.");
    }

    //remove item from shopping cart
    @Override
    public void remove(ItemInterface item) {
        getItemList().remove(item); //remove item from the cart
        item.setQuantity(item.getQuantity() - 1);   //reduce the quantity of items in the cart by 1
        item.setAvailableQuantity(item.getAvailableQuantity() + 1); //increase the available quantity of the item by 1
    }

    //remove all items with name = itemName from the shopping cart
    @Override
    public void remove(String itemName) {
        //List<ItemInterface> itemsToBeRemoved = new ArrayList<>();
        for (ItemInterface item : getItemList()) {
            if (item.getItemName().equals(itemName)) {
                //itemsToBeRemoved.add(item);
                item.setQuantity(item.getQuantity() - 1);   //reduce the quantity of items in the cart by 1
                item.setAvailableQuantity(item.getAvailableQuantity() + 1); //increase the available quantity of the item by 1
            }
        }
        //getItemList().removeAll(itemsToBeRemoved);  //remove all items from the cart with name = itemName
    }
}