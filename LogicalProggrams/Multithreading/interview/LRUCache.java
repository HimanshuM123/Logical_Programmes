package interview;

import java.util.*;

public class LRUCache<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, V> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public V get(K key) {
        return cache.getOrDefault(key, null);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public void display() {
        System.out.println(cache);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lru = new LRUCache<>(3);
        lru.put(1, "A");
        lru.put(2, "B");
        lru.put(3, "C");
        lru.display(); // Output: {1=A, 2=B, 3=C}

        lru.get(1);    // Access 1
        lru.put(4, "D"); // Add 4, evicts 2
        lru.display(); // Output: {3=C, 1=A, 4=D}
    }
}
