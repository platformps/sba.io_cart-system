package com.github.perschola.itemcontainerinterface;

import com.github.perschola.model.Item;
import com.github.perschola.model.ItemInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by leon on 8/24/2020.
 */
public class GetByNameTest {
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

        // when
        ItemInterface item = shoppingCartService.getByName(expectedName);
        String actualName = item.getItemName();
        Boolean hasCorrectName = Objects.equals(expectedName, actualName);

        // then
        Assertions.assertTrue(hasCorrectName);
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

        // when
        ItemInterface item = shoppingCartService.getByName(expectedName);
        String actualName = item.getItemName();
        Boolean hasCorrectName = Objects.equals(expectedName, actualName);

        // then
        Assertions.assertTrue(hasCorrectName);
    }
}
