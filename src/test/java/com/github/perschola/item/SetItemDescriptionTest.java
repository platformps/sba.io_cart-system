package com.github.perschola.item;

import com.github.perschola.model.Item;
import com.github.perschola.model.ItemInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Created by leon on 8/24/2020.
 */
public class SetItemDescriptionTest {
    @ParameterizedTest
    @ValueSource(strings = {"HDMI Cord", "Keyboard Cleaner", "Bubble Gum"})
    public void test(String expected) {
        // given
        ItemInterface item = (ItemInterface)new Item();
        item.setItemDescription(expected);

        // when
        String actual  = item.getItemDescription();

        // then
        Assertions.assertEquals(expected, actual);
    }
}
