package q00061m;

import tool.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedList_RotateRight {
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        test4();
    }

    /**
     * 快慢指针
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int i = 0;
        ListNode slow = head, fast = head;
        while (i < k) {
            fast = fast.next; // 快指针走，一直走到k或者走到结尾
            i++;
            if (fast == null) { // 当k>=链表长度时
                if (k % i == 0) { // 如果k是i的整数倍，则不需要旋转
                    return head;
                }
                int j = 0;
                i = k % i; // i取余数，此后只需走一次即可
                fast = head;
                while (j < i) {
                    fast = fast.next; // fast先走i步
                    j++;
                }
                break;
            }
        }
        while (fast.next != null) { // 快指针走到结束，慢指针跟着走到旋转点的前一个
            slow = slow.next;
            fast = fast.next;
        }
        ListNode nh = slow.next;
        fast.next = head; // 快指针指向头(下一个由null变为head)
        slow.next = null; // 慢指针的下一个剪断，变为空
        return nh;
    }

    private static void test1() {
        LinkedList_RotateRight rr = new LinkedList_RotateRight();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(rr.rotateRight(l1, 2));
    }

    private static void test2() {
        LinkedList_RotateRight rr = new LinkedList_RotateRight();
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        System.out.println(rr.rotateRight(l1, 4));
    }

    private static void test3() {
        LinkedList_RotateRight rr = new LinkedList_RotateRight();
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        System.out.println(rr.rotateRight(l1, 3));
    }

    private static void test4() {
        LinkedList_RotateRight rr = new LinkedList_RotateRight();
        ListNode l1 = new ListNode(1);
        System.out.println(rr.rotateRight(l1, 2));
    }
}
