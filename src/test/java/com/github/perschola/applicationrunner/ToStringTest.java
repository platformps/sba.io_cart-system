package com.github.perschola.applicationrunner;

import com.github.perschola.ApplicationRunner;
import com.github.perschola.itemcontainerinterface.ItemContainerInterface;
import com.github.perschola.itemcontainerinterface.ShoppingCartService;
import com.github.perschola.itemcontainerinterface.ShoppingStoreService;
import com.github.perschola.model.ItemInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created by leon on 8/24/2020.
 */
public class ToStringTest {
    private void test(List<ItemInterface> storeItems, List<ItemInterface> cartItems) {
        // given
        ItemContainerInterface store = (ItemContainerInterface) new ShoppingStoreService();
        ItemContainerInterface cart = (ItemContainerInterface) new ShoppingCartService();
        ApplicationRunner applicationRunner = new ApplicationRunner(store, cart);
        StringBuilder sb = new StringBuilder(applicationRunner.getHeader());
        applicationRunner.getItemCollection().forEach((k, item) -> sb.append(item.toString()));
        String expected = sb.toString();

        // when
        String actual = applicationRunner.toString();

        // then
        Assertions.assertEquals(expected, actual);
    }
}
