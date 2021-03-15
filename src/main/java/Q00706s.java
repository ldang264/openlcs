public class Q00706s {

    private final Integer[] map;

    /** Initialize your data structure here. */
    public Q00706s() {
        map = new Integer[100_0001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Integer value = map[key];
        return value == null ? -1 : value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = null;
    }
}
