import tool.ListNode;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * 示例 1：
 * 输入： 1->2
 * 输出： false
 *
 * 示例 2：
 * 输入： 1->2->2->1
 * 输出： true 
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00002_06s {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode curr = head;
        int len = 0; // 存储链表长度
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        ListNode prev = head; // 这是中点的前一位，len为奇数是正中间的那个，len是偶数就是偏左的那个
        for (int i = 0; i < (len - 1) / 2; i++) {
            prev = prev.next;
        }
        curr = prev.next; // 右半边的头
        while (curr.next != null) { // 翻转后半部分
            ListNode mnn = curr.next.next;
            ListNode mpn = prev.next;
            prev.next = curr.next;
            prev.next.next = mpn;
            curr.next = mnn;
        }
        curr = prev.next; // 回到右半边的头
        while (curr != null) {
            if (head.val != curr.val) return false; // 双指针，不相等立即返回，否则一起走
            head = head.next;
            curr = curr.next;
        }
        return true;
    }
}
