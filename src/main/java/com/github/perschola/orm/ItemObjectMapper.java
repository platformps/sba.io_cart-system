package com.github.perschola.orm;

import com.github.perschola.model.ItemInterface;

/**
 * Created by leon on 8/24/2020.
 */ // TODO - implement ItemObjectMapperInterface
public class ItemObjectMapper  implements ItemObjectMapperInterface{
    private String stringToParse;

    @Override
    public ItemInterface parseItem() {
        return null;
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