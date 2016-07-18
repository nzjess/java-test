package org.ubercraft.javatest.simplecache;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Provides threadsafe access to a cache of {@code AtomicInteger} instances,
 * indexed by a {@code String} key.
 */
public interface Cache {

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
    AtomicInteger getCachedValue(String key);
}
