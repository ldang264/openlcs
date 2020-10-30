package code.jdk;

public class MyLinkedHashMap {

    /**
     * HashMap.Node subclass for normal LinkedHashMap entries.
     */
    static class Entry<K,V> extends MyHashMap.Node<K,V> {
        Entry<K,V> before, after;
        Entry(int hash, K key, V value, MyHashMap.Node<K,V> next) {
            super(hash, key, value, next);
        }
    }
}
