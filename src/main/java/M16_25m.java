import java.util.HashMap;
import java.util.Map;

/**
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 /* 缓存容量 */ //);
        /*
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // 返回  1
        *cache.put(3,3);    // 该操作会使得密钥 2 作废
        *cache.get(2);       // 返回 -1 (未找到)
        *cache.put(4,4);    // 该操作会使得密钥 1 作废
        *cache.get(1);       // 返回 -1 (未找到)
        *cache.get(3);       // 返回  3
        *cache.get(4);       // 返回  4
        *
        *来源：力扣（LeetCode）
        *链接：https://leetcode-cn.com/problems/lru-cache-lcci
        *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_25m {

    private Map<Integer, Node> map; // 存放所有Node的

    private Node head; // 最新的元素

    private Node tail; // 最老的元素

    private int capacity;

    public M16_25m(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(-1, -1);
        head.prev = tail;
        tail.next = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if (n == null) return -1;
        n.prev.next = n.next;
        n.next.prev = n.prev;
        // 放到head的前面
        head.prev.next = n;
        n.prev = head.prev;
        n.next = head;
        head.prev = n;
        return n.value;
    }

    public void put(int key, int value) {
        if (map.size() == 0) {
            Node n = new Node(key, value);
            tail.next = n;
            n.next = head;
            head.prev = n;
            n.prev = tail;
            map.put(key, n);
        } else {
            // 如果存在则放到最前面，否则新建一个放到最前面
            Node n = map.get(key);
            if (n == null) { // 新建
                n = new Node(key, value);
                if (map.size() == capacity) { // 踢掉最老的那个
                    Node on = tail.next;
                    tail.next = on.next;
                    on.next.prev = tail;
                    map.remove(on.key);
                }
                map.put(key, n);
            } else { // 前后脱离
                n.value = value;
                n.prev.next = n.next;
                n.next.prev = n.prev;
            }
            // 放到head的前面
            head.prev.next = n;
            n.prev = head.prev;
            n.next = head;
            head.prev = n;
        }
    }

    private static class Node {

        private int key; // 键

        private int value; // 值

        Node prev; // 指向前一个

        Node next; // 指向后一个

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
