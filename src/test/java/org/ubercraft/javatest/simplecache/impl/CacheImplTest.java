package org.ubercraft.javatest.simplecache.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.ubercraft.javatest.simplecache.Cache;

public class CacheImplTest {

    @Test
    public void testCache() {
        Cache cache = new CacheImpl();

        AtomicInteger foo = cache.getCachedValue("foo");
        AtomicInteger bar = cache.getCachedValue("bar");

        assertEquals(0, foo.get());
        assertEquals(0, bar.get());

        foo.set(1);

        assertEquals(1, foo.get());

        AtomicInteger foo1 = cache.getCachedValue("foo");
        AtomicInteger bar1 = cache.getCachedValue("bar");

        assertEquals(1, foo1.get());
        assertEquals(0, bar1.get());

        assertSame(foo, foo1);
        assertSame(bar, bar1);

        assertNotSame(foo, bar);
        assertNotSame(foo1, bar1);
        assertNotSame(foo, bar1);
        assertNotSame(foo1, bar1);
    }
}
