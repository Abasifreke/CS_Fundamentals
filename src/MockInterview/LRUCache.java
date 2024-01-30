package MockInterview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
// import java.util.concurrent.locks.ReadWriteLock;
// import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache {

    final long DEFAULT_EXP = 1_000_000L;

    class Expiration {
        long expiration;
        long createdAt;

        Expiration(long expiration, long createdAt){
            this.expiration = expiration;
            this.createdAt = createdAt;
        }
    }

    private final int capacity;
    private final Map<Integer, Object> cache;
    private final LinkedList<Integer> order;
    private final Map<Integer, Expiration> expirator;

    // private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<>();
        this.order = new LinkedList<>();
        this.expirator = new HashMap<>();
    }

    public Object get(int key) {
        if (!cache.containsKey(key) 
        || !expirator.containsKey(key)
        || System.currentTimeMillis() - expirator.get(key).createdAt > expirator.get(key).expiration) {
            return null;
        }
        
        order.remove(Integer.valueOf(key));
        order.addFirst(key);
        return cache.get(key);
    }

    public void put(int key, Object value) {
        if (cache.containsKey(key)) {
            order.remove(Integer.valueOf(key));
        } else if (cache.size() == capacity) {
            int leastUsed = order.removeLast();
            cache.remove(leastUsed);
            expirator.remove(leastUsed);
        }
        order.addFirst(key);
        cache.put(key, value);
        expirator.put(key, new Expiration(this.DEFAULT_EXP, System.currentTimeMillis()));
    }

}
