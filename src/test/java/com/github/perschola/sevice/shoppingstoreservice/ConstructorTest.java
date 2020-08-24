package com.github.perschola.sevice.shoppingstoreservice;

import com.github.perschola.model.ItemInterface;
import com.github.perschola.service.ShoppingCartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by leon on 8/24/2020.
 */
public class ConstructorTest {
    @Test
    public void testPolymorphism() {
        // given
        ShoppingCartService shoppingCartService = new ShoppingCartService();

        // when
        boolean isItemInterface = shoppingCartService instanceof ItemInterface;

        // then
        Assertions.assertTrue(isItemInterface);
    }
}
