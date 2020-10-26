package q00148m_todo;

import algorithm.sort.HeapSort;
import tool.ListNode;

import java.util.ArrayList;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedList_SortList {
    public static void main(String[] args) {
        LinkedList_SortList sl = new LinkedList_SortList();
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(3);
        System.out.println(sl.sortList(l1));

        ListNode l2 = new ListNode(-1);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);
        l2.next.next.next.next = new ListNode(0);
        System.out.println(sl.sortList(l2));

        System.out.println(sl.sortList(null));

        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(4);
        System.out.println(sl.sortList(l3));
    }

    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        Integer[] array = list.toArray(new Integer[list.size()]);
        HeapSort.sort(array);
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        for (int i = 0; i < array.length; i++) {
            curr.next = new ListNode(array[i]);
            curr = curr.next;
        }
        return ans.next;
    }
}
