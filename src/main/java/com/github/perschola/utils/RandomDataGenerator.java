package com.github.perschola.utils;

/**
 * Created by leon on 8/24/2020.
 */

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Leon on 2/4/2017.
 */
public final class RandomDataGenerator {
    private final Random random;

    public RandomDataGenerator() {
        this(new Random());
    }

    public RandomDataGenerator(Random random) {
        this.random = random;
    }

    /**
     * @return true with the likelihood of specified percentage
     */
    public boolean createBoolean(float percentage) {
        return percentage > createDouble(0, 100);
    }

    /**
     * @return a random character between the specified min and max character range
     */
    public Character createCharacter(char min, char max) {
        return (char) createInteger((int) min, (int) max).intValue();
    }

    /**
     * @return a random double between the specified min and max numeric range
     */
    public Float createFloat(float min, float max) {
        return createDouble(min, max).floatValue();
    }

    /**
     * @return a random float between the specified min and max numeric range
     */
    public Double createDouble(double min, double max) {
        return random.nextDouble() * (max - min) + min;
    }

    /**
     * @return a random integer between the specified min and max numeric range
     */
    public Integer createInteger(int min, int max) {
        return createDouble(min, max).intValue();
    }

    /**
     * @return a random long between the specified min and max numeric range
     */
    public Long createLong(long min, long max) {
        return createDouble(min, max).longValue();
    }

    /**
     * @return a random string of the specified length containing characters in the specified range
     */
    public String createString(char min, char max, int stringLength) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stringLength; i++) {
            sb.append(createCharacter(min, max));
        }
        return sb.toString();
    }

    /**
     * @return an array of random string objects of the specified length containing characters in the specified range
     */
    public String[] createStrings(char min, char max, int stringLength, int stringCount) {
        String[] strings = new String[stringCount];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = createString(min, max, stringLength);
        }
        return strings;
    }
}