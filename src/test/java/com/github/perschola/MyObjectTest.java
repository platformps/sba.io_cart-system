package com.github.perschola;

import org.junit.Assert;
import org.junit.Test;

/**
 * Implemented by Monica Deshmukh
 * 08/15/2020
 */
public class MyObjectTest {
    @Test
    public void testRun() { // TODO
        // Given
        ApplicationRunner myObject = new ApplicationRunner();

        // when
        myObject.run();

        //then
        Assert.assertNotNull(myObject.toString());
    }
}
