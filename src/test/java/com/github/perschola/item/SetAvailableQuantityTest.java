package com.github.perschola.item;

import com.github.perschola.model.Item;
import com.github.perschola.model.ItemInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Created by leon on 8/24/2020.
 */
public class SetAvailableQuantityTest {
    @ParameterizedTest
    @ValueSource(ints = {11,19,30})
    public void test(int expected) {
        // given
        ItemInterface item = (ItemInterface)new Item();
        item.setAvailableQuantity(expected);

        // when
        int actual  = item.getAvailableQuantity();

        // then
        Assertions.assertEquals(expected, actual);
    }
}
