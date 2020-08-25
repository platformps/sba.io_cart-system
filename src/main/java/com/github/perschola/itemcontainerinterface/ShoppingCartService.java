package com.github.perschola.itemcontainerinterface;

import com.github.perschola.model.ItemInterface;

import java.util.ArrayList;
import java.util.List;

// TODO - implements ItemContainerInterface
public class ShoppingCartService implements ItemContainerInterface{
    private List<ItemInterface> list = new ArrayList<>();
    @Override
    public List<ItemInterface> getList() {
        return list;
    }
}
