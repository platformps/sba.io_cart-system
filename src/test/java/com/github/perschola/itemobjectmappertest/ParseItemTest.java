package com.github.perschola.itemobjectmappertest;

import com.github.perschola.utils.ItemBuilder;
import com.github.perschola.model.ItemInterface;
import com.github.perschola.orm.ItemObjectMapper;
import com.github.perschola.orm.ItemObjectMapperInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

/**
 * Created by leon on 8/24/2020.
 */
public class ParseItemTest {

    // given
    private void test(String itemName, String itemDescription, Double itemPrice, Integer itemQuantity, Integer itemAvailableQuantity) {
        ItemObjectMapperInterface itemObjectMapper = (ItemObjectMapperInterface) new ItemObjectMapper();
        itemObjectMapper.setStringToParse(new StringJoiner("  ")
                .add(itemName == null ? "" : itemName) // append if not null
                .add(itemDescription == null ? "" : itemDescription) // append if not null
                .add(itemPrice == null ? "" : itemPrice.toString()) // append if not null
                .add(itemQuantity == null ? "" : itemQuantity.toString()) // append if not null
                .add(itemAvailableQuantity == null ? "" : itemAvailableQuantity.toString()) // append if not null
                .toString());

        ItemInterface expectedItem = new ItemBuilder()
                .setItemName(itemName)
                .setItemDescription(itemDescription)
                .setItemPrice(itemPrice)
                .setQuantity(itemQuantity)
                .build();


        // when
        ItemInterface actualItem = itemObjectMapper.parseItem();

        // then
        Assertions.assertEquals(expectedItem, actualItem);
    }

    @Test
    public void test1() {
        String itemName = "pizza";
        String itemDescription = "very cheesy";
        Double itemPrice = 12.30;
        Integer itemQuantity = 3;
        test(itemName, itemDescription, itemPrice, itemQuantity, null);
    }


    @Test
    public void test2() {
        // salad  cobb salad  15.50  12
        String itemName = "salad";
        String itemDescription = "cobb salad";
        Double itemPrice = 15.50;
        Integer itemQuantity = 12;
        test(itemName, itemDescription, itemPrice, itemQuantity, null);
    }


    @Test
    public void test3() {
        // hunger burger  huge patty  9.49  10
        String itemName = "hunger burger";
        String itemDescription = "huge patty";
        Double itemPrice = 9.49;
        Integer itemQuantity = 10;
        test(itemName, itemDescription, itemPrice, itemQuantity, null);
    }


    @Test
    public void test4() {
        // fried chicken  so crispy  18.99  5
        String itemName = "fried chicken";
        String itemDescription = "so crispy";
        Double itemPrice = 18.99;
        Integer itemQuantity = 5;
        test(itemName, itemDescription, itemPrice, itemQuantity, null);
    }
}
