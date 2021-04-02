/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val和next。val是当前节点的值，next是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性prev以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
 *
 * 示例：
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 * 提示：
 * 所有val值都在[1, 1000]之内。
 * 操作次数将在[1, 1000]之内。
 * 请不要使用内置的 LinkedList 库。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00707m {

    private final DNode head;

    private final DNode tail;

    private int size;

    /** Initialize your data structure here. */
    /**
     * 创建头尾节点，初始化时头尾相连
     */
    public Q00707m() {
        head = new DNode(-1);
        tail = new DNode(-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size || index < 0) return -1; // 非法下标
        DNode curr;
        if (index <= (size >> 1)) { // 偏于左边从head去找
            curr = head;
            while (index-- >= 0) curr = curr.next;
        } else { // 偏于右边从tail去找
            curr = tail;
            while (index++ < size) curr = curr.prev;
        }
        return curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAfter(head, val); // 在头节点后面插入
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addBefore(tail, val); // 在尾节点前面插入
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index == size) {
            addAtTail(val); // 在尾节点前面插入
        } else if (index <= 0) {
            addAtHead(val); // 在头节点后面插入
        } else {
            DNode curr;
            if (index <= (size >> 1)) { // 偏于左边从head去找
                curr = head;
                while (index-- > 0) curr = curr.next;
                addAfter(curr, val); // 插入在目标节点后面
            } else { // 偏于右边从tail去找
                curr = tail;
                while (index++ < size) curr = curr.prev;
                addBefore(curr, val); // 插入在目标节点前面
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) return;
        DNode curr;
        if (index <= (size >> 1)) { // 偏于左边从head去找
            curr = head;
            while (index-- > 0) curr = curr.next;
            // 将curr.next引用移除
            curr.next = curr.next.next;
            curr.next.prev = curr;
        } else { // 偏于右边从tail去找
            curr = tail;
            while (index++ < size - 1) curr = curr.prev;
            // 将curr.prev引用移除
            curr.prev = curr.prev.prev;
            curr.prev.next = curr;
        }
        size--;
    }

    private void addAfter(DNode curr, int val) {
        DNode node = new DNode(val);
        DNode hn = curr.next;
        curr.next = node;
        node.next = hn;
        hn.prev = node;
        node.prev = curr;
        size++;
    }

    private void addBefore(DNode curr, int val) {
        DNode node = new DNode(val);
        DNode tp = curr.prev;
        curr.prev = node;
        node.prev = tp;
        tp.next = node;
        node.next = curr;
        size++;
    }

    private static class DNode {

        private int val;

        private DNode prev;

        private DNode next;

        public DNode(int val) {
            this.val = val;
        }
    }
}
