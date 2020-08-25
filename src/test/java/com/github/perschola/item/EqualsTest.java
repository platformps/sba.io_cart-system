package com.github.perschola.item;

import com.github.perschola.model.Item;
import com.github.perschola.utils.ItemBuilder;
import com.github.perschola.model.ItemInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by leon on 8/24/2020.
 */
public class EqualsTest {
    // given
    private void positiveTest(int randomAvailableQuantity, int randomQuantity, String randomDescription, String randomName, Double randomPrice) {
        ItemBuilder itemBuilder = new ItemBuilder()
                .setAvailableQuantity(randomAvailableQuantity)
                .setQuantity(randomQuantity)
                .setItemDescription(randomDescription)
                .setItemName(randomName)
                .setItemPrice(randomPrice);

        ItemInterface item1 = itemBuilder.build();
        ItemInterface item2 = itemBuilder.build();

        // when
        boolean isEqual = item1.equals(item2);

        // then
        Assertions.assertTrue(isEqual);
    }

    // given
    private void negativeTest(int randomAvailableQuantity, int randomQuantity, String randomDescription, String randomName, Double randomPrice) {
        ItemInterface item1 = (ItemInterface) new Item();
        ItemInterface item2 = new ItemBuilder()
                .setAvailableQuantity(randomAvailableQuantity)
                .setQuantity(randomQuantity)
                .setItemDescription(randomDescription)
                .setItemName(randomName)
                .setItemPrice(randomPrice)
                .build();

        // when
        boolean isEqual = item2.equals(item1);

        // then
        Assertions.assertFalse(isEqual);
    }

    @Test
    public void positiveTest1() {
        Integer availableQuantity = 10;
        Integer quantity = availableQuantity - 1;
        String description = "flat screen";
        String name = "Television";
        Double price = 3.5;
        positiveTest(availableQuantity, quantity, description, name, price);
    }

    @Test
    public void positiveTest2() {
        Integer availableQuantity = 4;
        Integer quantity = availableQuantity - 1;
        String description = "Apple Jacks";
        String name = "Cereal";
        Double price = 5.3;
        positiveTest(availableQuantity, quantity, description, name, price);
    }


    @Test
    public void negativeTest1() {
        Integer availableQuantity = 10;
        Integer quantity = availableQuantity - 1;
        String description = "iPhone";
        String name = "Cell Phone";
        Double price = 1005.0;
        negativeTest(availableQuantity, quantity, description, name, price);
    }

    @Test
    public void negativeTest2() {
        Integer availableQuantity = 4;
        Integer quantity = availableQuantity - 1;
        String description = "MacBook Air";
        String name = "Computer";
        Double price = 3300.0;
        negativeTest(availableQuantity, quantity, description, name, price);
    }
}
