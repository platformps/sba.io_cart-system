package com.github.perschola.orm;

import com.github.perschola.model.ItemInterface;
import com.github.perschola.utils.ItemBuilder;

/**
 * Created by leon on 8/24/2020.
 */ // TODO - implement ItemObjectMapperInterface
public class ItemObjectMapper  implements ItemObjectMapperInterface{
    private String stringToParse;

    @Override
    public ItemInterface parseItem() {
        String[] fields =  stringToParse.split("  ");
        String itemName = fields[0];
        String itemDescription = fields[1];
        String itemPrice = fields[2];
        String itemQuantity = fields[3];
        return new ItemBuilder()
                .setItemName(itemName)
                .setItemDescription(itemDescription)
                .setItemPrice(Double.parseDouble(itemPrice))
                .setQuantity(Integer.parseInt(itemQuantity))
                .build();
    }

    @Override
    public String getStringToParse() {
        return stringToParse;
    }

    @Override
    public void setStringToParse(String stringToParse) {
        this.stringToParse = stringToParse;
    }
}