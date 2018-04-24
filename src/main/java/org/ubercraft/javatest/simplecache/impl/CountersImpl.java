package org.ubercraft.javatest.simplecache.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.ubercraft.javatest.simplecache.Counters;

/**
 * Provides threadsafe access to a set of counts, indexed by a {@code String} key.
 *
 * TODO:
 *   Re-implement this class in Java 7, preserving all documented semantics including thread-safety,
 *   and preserving performance characteristics of this Java 8 implementation.
 */
public class CountersImpl implements Counters {

    private final ConcurrentMap<String, AtomicInteger> store = new ConcurrentHashMap<>();

    /**
     * Returns the next integer count for a given key, starting at zero.
     *
     * Maintains a separate counter per unique key.
     *
     * This method is threadsafe.
     */
    @Override
    public int getNextValue(String key) {
        return store.computeIfAbsent(key, k -> new AtomicInteger()).getAndIncrement();
    }
}
