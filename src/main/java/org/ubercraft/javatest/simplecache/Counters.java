package org.ubercraft.javatest.simplecache;

/**
 * Provides threadsafe access to a set of counts, indexed by a {@code String} key.
 */
public interface Counters {

    /**
     * Returns the next integer count for a given key, starting at zero.
     *
     * Maintains a separate counter per unique key.
     *
     * This method is threadsafe.
     */
    int getNextValue(String key);
}
