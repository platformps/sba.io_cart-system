package com.github.perschola.service;

import com.github.perschola.model.ItemInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by leon on 8/24/2020.
 */
public class ConstructorTest {
    @Test
    public void testShoppingCartServicePolymorphism() {
        // given
        ShoppingCartService shoppingCartService = new ShoppingCartService();

        // when
        boolean isItemInterface = shoppingCartService instanceof ItemInterface;

        // then
        Assertions.assertTrue(isItemInterface);
    }

    @Test
    public void testShoppingStoreServicePolymorphism() {
        // given
        ShoppingStoreService shoppingCartService = new ShoppingStoreService();

        // when
        boolean isItemInterface = shoppingCartService instanceof ItemInterface;

        // then
        Assertions.assertTrue(isItemInterface);
    }
}
