package com.github.perschola.applicationrunner;

import com.github.perschola.ApplicationRunner;
import com.github.perschola.itemcontainerinterface.ItemContainerInterface;
import com.github.perschola.itemcontainerinterface.ShoppingCartService;
import com.github.perschola.itemcontainerinterface.ShoppingStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by leon on 8/24/2020.
 */
public class GetHeader {
    @Test
    public void test() {
        // given
        ItemContainerInterface store = (ItemContainerInterface) new ShoppingStoreService();
        ItemContainerInterface cart = (ItemContainerInterface) new ShoppingCartService();
        Runnable applicationRunner = new ApplicationRunner(store, cart);
        String expected = String.format("AppSystem Inventory:\n%-20s %-20s %-10s %-10s\n", "Name", "Description", "Price", "Available Quantity");


        // when
        String actual = applicationRunner.toString();

        // then
        Assertions.assertEquals(expected, actual);
    }
}
