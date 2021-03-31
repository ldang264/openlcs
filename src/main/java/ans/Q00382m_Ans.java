package ans;

import tool.ListNode;

import java.util.Random;

/**
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 * <p>
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 * <p>
 * 示例:
 * <p>
 * // 初始化一个单链表 [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * <p>
 * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
 * solution.getRandom();
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-random-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *
 作者：bock123
 链接：https://leetcode-cn.com/problems/linked-list-random-node/solution/xu-shui-chi-chou-yang-suan-fa-reservoir-jvnmc/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q00382m_Ans {

    private final ListNode head;
    private final Random rd = new Random();

    public Q00382m_Ans(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int ans = 0;
        int cnt = 0;
        ListNode p = head;
        while (p != null) {
            if (rd.nextInt(++cnt) == 0) {
                ans = p.val;
            }
            p = p.next;
        }
        return ans;
    }

}
