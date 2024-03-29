/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 );
    *
    *cache.put(1,1);
    *cache.put(2,2);
    *cache.get(1);       // 返回  1
    *cache.put(3,3);    // 该操作会使得关键字 2 作废
    *cache.get(2);       // 返回 -1 (未找到)
    *cache.put(4,4);    // 该操作会使得关键字 1 作废
    *cache.get(1);       // 返回 -1 (未找到)
    *cache.get(3);       // 返回  3
    *cache.get(4);       // 返回  4
    *
    *来源：力扣（LeetCode）
    *链接：https://leetcode-cn.com/problems/lru-cache
    *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class Q00146m {

    private Map<Integer, Node> map; // 存放所有Node的

    private Node head; // 最新的元素

    private Node tail; // 最老的元素

    private int capacity;

    public Q00146m(int capacity) {
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

    /**
     ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
     [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]

     [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,24,null,4,-1,-1,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,24,null,null,null,20,null,null,null,29,18,18,null,null,null,null,20,null,null,null,null,null,null,null]
     [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,-1,null,null,null,20,null,null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null]
     */

    /*
    static class Node {
        int key;
        
        int value;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }*/
}
