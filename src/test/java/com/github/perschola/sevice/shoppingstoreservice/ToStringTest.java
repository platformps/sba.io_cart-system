package com.github.perschola.sevice.shoppingstoreservice;

import com.github.perschola.model.Item;
import com.github.perschola.model.ItemInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by leon on 8/24/2020.
 */
public class ToStringTest {
    @Test
    public void test() {
        // given
        ItemInterface item = (ItemInterface) new Item();
        String itemName = "Thesaurus";
        String itemDescription = "A tool to find words with (dis)similar meanings.";
        Double itemPrice = 5.00;
        Integer itemQuantity = 3;
        Integer availableQuantity = 4;
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
}
