package com.github.perschola.itemcontainerinterface;

import com.github.perschola.model.Item;
import com.github.perschola.model.ItemInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by leon on 8/24/2020.
 */
public class RemoveByNameTest {
    // given
    @ParameterizedTest
    @ValueSource(strings = {"HDMI Cord", "Keyboard Cleaner", "Bubble Gum"})
    public void testShoppingCartService(String expectedName) {
        ItemInterface firstItemWithExpectedName = (ItemInterface) new Item();
        ItemInterface secondItemWithExpectedName = (ItemInterface) new Item();
        secondItemWithExpectedName.setItemName(expectedName);
        firstItemWithExpectedName.setItemName(expectedName);

        List<ItemInterface> itemsToBeAdded = Arrays.asList(
                firstItemWithExpectedName,
                secondItemWithExpectedName,
                (ItemInterface) new Item(),
                (ItemInterface) new Item(),
                (ItemInterface) new Item(),
                (ItemInterface) new Item());
        Collections.shuffle(itemsToBeAdded);

        ItemContainerInterface shoppingCartService = (ItemContainerInterface) new ShoppingCartService();
        itemsToBeAdded.forEach(shoppingCartService::add);
        itemsToBeAdded.forEach(item -> Assertions.assertTrue(shoppingCartService.checkAvailability(item)));
        Integer quantityPriorToRemoval = firstItemWithExpectedName.getAvailableQuantity();
        Integer expectedQuantity = quantityPriorToRemoval - 1;

        // when
        shoppingCartService.removeByName(expectedName);
        Integer actualQuantity = firstItemWithExpectedName.getQuantity();

        // then
        Assertions.assertEquals(expectedQuantity, actualQuantity);
    }

    // given
    @ParameterizedTest
    @ValueSource(strings = {"HDMI Cord", "Keyboard Cleaner", "Bubble Gum"})
    public void testShoppingStoreService(String expectedName) {
        ItemInterface firstItemWithExpectedName = (ItemInterface) new Item();
        ItemInterface secondItemWithExpectedName = (ItemInterface) new Item();
        secondItemWithExpectedName.setItemName(expectedName);
        firstItemWithExpectedName.setItemName(expectedName);

        List<ItemInterface> itemsToBeAdded = Arrays.asList(
                firstItemWithExpectedName,
                secondItemWithExpectedName,
                (ItemInterface) new Item(),
                (ItemInterface) new Item(),
                (ItemInterface) new Item(),
                (ItemInterface) new Item());
        Collections.shuffle(itemsToBeAdded);

        ItemContainerInterface shoppingCartService = (ItemContainerInterface) new ShoppingStoreService();
        itemsToBeAdded.forEach(shoppingCartService::add);
        itemsToBeAdded.forEach(item -> Assertions.assertTrue(shoppingCartService.checkAvailability(item)));
        Integer quantityPriorToRemoval = firstItemWithExpectedName.getAvailableQuantity();
        Integer expectedQuantity = quantityPriorToRemoval - 1;

        // when
        shoppingCartService.removeByName(expectedName);
        Integer actualQuantity = firstItemWithExpectedName.getQuantity();

        // then
        Assertions.assertEquals(expectedQuantity, actualQuantity);
    }
}
