package com.github.perschola.orm;

import com.github.perschola.model.ItemInterface;

public interface ItemObjectMapperInterface {
    ItemInterface parseItem();

    String getStringToParse();

    void setStringToParse(String stringToParse);

}
