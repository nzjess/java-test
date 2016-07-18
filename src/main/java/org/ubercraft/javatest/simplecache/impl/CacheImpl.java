package org.ubercraft.javatest.simplecache.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.ubercraft.javatest.simplecache.Cache;

/**
 * Provides threadsafe access to a cache of {@code AtomicInteger} instances,
 * indexed by a {@code String} key.
 *
 * TODO:
 *   Re-implement this class in Java 7, preserving all documented semantics including thread-safety,
 *   and preserving performance characteristics of this Java 8 implementation.
 */
public class CacheImpl implements Cache {

    private final ConcurrentMap<String, AtomicInteger> store = new ConcurrentHashMap<>();

    /**
     * Returns a cached {@code AtomicInteger} instance for the given key.
     *
     * This method always returns the same {@code AtomicInteger} instance for any given key,
     * and a different {@code AtomicInteger} instance for any two different keys.
     *
     * This method never returns null.
     *
     * This method is threadsafe.
     */
    @Override
    public AtomicInteger getCachedValue(String key) {
        return store.computeIfAbsent(key, k -> new AtomicInteger());
    }
}
