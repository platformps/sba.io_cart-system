package com.github.perschola.service;

import com.github.perschola.model.ItemInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Implemented by Monica Deshmukh
 * 08/15/2020
 */
public abstract class AbstractItemContainer implements ItemContainer{
    private List<ItemInterface> itemList;

    public AbstractItemContainer() {
        this(new ArrayList<>());
    }

    public AbstractItemContainer(List<ItemInterface> itemList) {
        this.itemList = itemList;
    }

    @Override
    public List<ItemInterface> getItemList() {
        return itemList;
    }
}
