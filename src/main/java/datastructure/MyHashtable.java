package datastructure;

public class MyHashtable<K, V> {

    private final MyLinkedList<Entry<K, V>>[] bucket;

    public MyHashtable(int bucketSize) {
        //noinspection unchecked
        this.bucket = new MyLinkedList[bucketSize];
        for (int i = 0; i < bucketSize; i++) {
            this.bucket[i] = new MyLinkedList<>();
        }
    }

    void put(K key, V value) {
        int i = toIndex(key);

        for (Entry<K, V> e : bucket[i]) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
        }

        Entry<K, V> e = new Entry<>();
        e.key = key;
        e.value = value;
        bucket[i].add(e);
    }

    V get(K key) {
        int i = toIndex(key);
        for (Entry<K, V> entry : bucket[i])
            if (entry.key.equals(key)) return entry.value;
        return null;
    }

    private int toIndex(K key) {
        return key.hashCode() % bucket.length;
    }

    private static class Entry<K, V> {
        K key;
        V value;
    }
}
