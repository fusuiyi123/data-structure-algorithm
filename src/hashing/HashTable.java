package hashing;

public class HashTable {

    int size;

    private int hash(Object key) {
        return (key.hashCode() & 0x7ffffff) % size;

        // bug...
        // key.hashCode() % size
        // Math.abs(key.hashCode()) % size;
    }

    // separate chaining, linear probing
    void put(Object key, Object value) {}

    Object get(Object key) { return null; }


}
