package com.github.perschola.itemobjectmappertest;

import com.github.perschola.orm.ItemObjectMapper;
import com.github.perschola.orm.ItemObjectMapperInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by leon on 8/24/2020.
 */
public class ConstructorTest {
    @Test
    public void test() {
        // given
        ItemObjectMapperInterface itemObjectMapper = (ItemObjectMapperInterface)new ItemObjectMapper();

        // when
        boolean isItemObjectMapperInterface = itemObjectMapper instanceof ItemObjectMapperInterface;

        // then
        Assertions.assertTrue(isItemObjectMapperInterface);
    }
}
