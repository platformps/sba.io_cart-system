package com.github.perschola.item;

import com.github.perschola.model.Item;
import com.github.perschola.model.ItemInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by leon on 8/24/2020.
 */
public class NullaryConstructorTest {
    @Test
    public void testPolymorphism() {
        // given
        ItemInterface item = (ItemInterface)new Item();

        // when
        boolean isItemInterface = item instanceof  ItemInterface;

        // then
        Assertions.assertTrue(isItemInterface);
    }
}
