package org.ubercraft.javatest.simplecache.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.ubercraft.javatest.simplecache.Counters;

public class CountersImplTest {

    @Test
    public void testCounters() {
        Counters counters = new CountersImpl();

        int foo0 = counters.getNextValue("foo");
        int bar0 = counters.getNextValue("bar");

        assertEquals(0, foo0);
        assertEquals(0, bar0);

        int bar1 = counters.getNextValue("bar");
        int baz0 = counters.getNextValue("baz");

        assertEquals(1, bar1);
        assertEquals(0, baz0);
    }
}
