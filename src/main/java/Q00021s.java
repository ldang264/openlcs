import tool.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00021s {
    public static void main(String[] args) {
        Q00021s mtl = new Q00021s();
        ListNode l13 = new ListNode(4);
        ListNode l12 = new ListNode(2);
        l12.next = l13;
        ListNode l1 = new ListNode(1);
        l1.next = l12;

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(3);
        l22.next = l23;
        ListNode l2 = new ListNode(1);
        l2.next = l22;

        ListNode listNode = mtl.mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head;
        if (l1.val <= l2.val) {
            head = new ListNode(l1.val); // head指向l1的第一个节点
            l1 = l1.next;
        } else {
            head = new ListNode(l2.val); // head指向l2的第一个节点
            l2 = l2.next;
        }
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        return head;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                list.addFirst(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                list.addFirst(l1.val);
                l1 = l1.next;
            } else {
                if (l1.val > l2.val) {
                    list.addFirst(l2.val);
                    l2 = l2.next;
                } else {
                    list.addFirst(l1.val);
                    l1 = l1.next;
                }
            }
        }
        ListNode currNode = new ListNode(list.removeFirst());
        while (list.size() > 0) {
            ListNode prev = new ListNode(list.removeFirst());
            prev.next = currNode;
            currNode = prev;
        }
        return currNode;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                list.addFirst(l2.val);
                l2 = l2.next;
            } else {
                list.addFirst(l1.val);
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            list.addFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list.addFirst(l2.val);
            l2 = l2.next;
        }
        ListNode currNode = new ListNode(list.removeFirst());
        while (list.size() > 0) {
            ListNode prev = new ListNode(list.removeFirst());
            prev.next = currNode;
            currNode = prev;
        }
        return currNode;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        List<ListNode> list = new ArrayList<>();
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                list.add(new ListNode(l2.val));
                l2 = l2.next;
            } else {
                list.add(new ListNode(l1.val));
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            list.add(new ListNode(l1.val));
            l1 = l1.next;
        }
        while (l2 != null) {
            list.add(new ListNode(l2.val));
            l2 = l2.next;
        }
        for (int i=0; i<list.size()-1; i++) {
            ListNode prev = list.get(i);
            prev.next = list.get(i+1);
        }
        return list.get(0);
    }
}
