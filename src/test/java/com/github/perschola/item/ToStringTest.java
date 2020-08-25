package com.github.perschola.item;

import com.github.perschola.model.Item;
import com.github.perschola.model.ItemInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by leon on 8/24/2020.
 */
public class ToStringTest {
    private void test(String itemName, String itemDescription, Double itemPrice, Integer itemQuantity, Integer availableQuantity) {
        // given
        ItemInterface item = (ItemInterface) new Item();
        item.setItemName(itemName);
        item.setItemDescription(itemDescription);
        item.setItemPrice(itemPrice);
        item.setQuantity(itemQuantity);
        item.setAvailableQuantity(availableQuantity);

        String expected = String.format("%-20s %-20s %-10.2f %-10d\n",
                item.getItemName(),
                item.getItemDescription(),
                item.getItemPrice(),
                item.getAvailableQuantity());

        // when
        String actual = item.toString();

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        String itemName = "Thesaurus";
        String itemDescription = "A tool to find words with (dis)similar meanings.";
        Double itemPrice = 5.00;
        Integer itemQuantity = 3;
        Integer availableQuantity = 4;
        test(itemName, itemDescription, itemPrice, itemQuantity, availableQuantity);
    }


    @Test
    public void test2() {
        String itemName = "Dictionary";
        String itemDescription = "A tool to find word meanings.";
        Double itemPrice = 5.40;
        Integer itemQuantity = 2;
        Integer availableQuantity = 5;
        test(itemName, itemDescription, itemPrice, itemQuantity, availableQuantity);
    }

    @Test
    public void test3() {
        String itemName = "Encyclopedia";
        String itemDescription = "A tool to find information.";
        Double itemPrice = 5.40;
        Integer itemQuantity = 2;
        Integer availableQuantity = 5;
        test(itemName, itemDescription, itemPrice, itemQuantity, availableQuantity);
    }
}
