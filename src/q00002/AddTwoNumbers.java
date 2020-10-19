package q00002;

import tool.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 输入：(4 -> 3) + (5 -> 6 -> 4)
 * 输出：9 -> 9 -> 4
 * 原因：34 + 465 = 499
 *
 * 输入：(3) + (5 -> 6 -> 4)
 * 输出：8 -> 6 -> 4
 * 原因：3 + 465 = 468
 *
 * 输入：(6) + (5 -> 6 -> 4)
 * 输出：1 -> 7 -> 4
 * 原因：6 + 465 = 471
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        /*l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(1);*/
        System.out.println("l1:" + l1);

        ListNode l2 = new ListNode(1);
        /*l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);*/
        System.out.println("l2:" + l2);

        ListNode listNode = atn.addTwoNumbers(l1, l2);
        System.out.println("result:" + listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        boolean ten = false;
        ListNode curr = root;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            ListNode now = new ListNode(0);
            ten = set(now, sum, ten);
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next = now;
        }
        while (l1 != null) {
            int sum = l1.val;
            ListNode now = new ListNode(0);
            ten = set(now, sum, ten);
            l1 = l1.next;
            curr = curr.next = now;
        }
        while (l2 != null) {
            int sum = l2.val;
            ListNode now = new ListNode(0);
            ten = set(now, sum, ten);
            l2 = l2.next;
            curr = curr.next = now;
        }
        if (ten) {
            curr.next = new ListNode(1);
        }
        return root.next;
    }

    private boolean set (ListNode now, int sum, boolean ten) {
        if (ten) {
            if (sum < 9) {
                now.val = sum + 1; // 1,2,3,4,5,6,7,8,9
                ten = false;
            } else if (sum > 9) {
                now.val = sum - 9; // 0
            }
        } else {
            if (sum <= 9) {
                now.val = sum; // 0,1,2,3,4,5,6,7,8,9
            } else {
                now.val = sum - 10; // 0,1,2,3,4,5,6,7,8
                ten = true;
            }
        }
        return ten;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        boolean ten = false;
        ListNode curr = root;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            ListNode now = new ListNode(0);
            if (sum < 9) { // 0,1,2,3,4,5,6,7,8
                if (ten) { // +1
                    now.val = sum + 1; // 1,2,3,4,5,6,7,8,9
                } else {
                    now.val = sum; // 0,1,2,3,4,5,6,7,8
                }
                ten = false; // 不进位
            } else if (sum == 9){ // 9
                if (ten) { // +1
                    now.val = 0; // 0
                } else {
                    now.val = sum; // 9
                    ten = false;
                }
            } else { // 10,11,12,13,14,15,16,17,18
                if (ten) { // +1
                    now.val = sum - 9; // 0
                } else {
                    now.val = sum - 10; // 0,1,2,3,4,5,6,7,8
                    ten = true;
                }
            }
            l1 = l1.next;
            l2 = l2.next;
            curr.next = now;
            curr = curr.next;
        }
        while (l1 != null) {
            ListNode now = new ListNode(0);
            int sum = l1.val;
            if (sum < 9) { // 0,1,2,3,4,5,6,7,8
                if (ten) { // +1
                    now.val = sum + 1; // 1,2,3,4,5,6,7,8,9
                } else {
                    now.val = sum; // 0,1,2,3,4,5,6,7,8
                }
                ten = false; // 不进位
            } else if (sum == 9){ // 9
                if (ten) { // +1
                    now.val = 0; // 0
                } else {
                    now.val = sum; // 9
                    ten = false;
                }
            } else { // 10,11,12,13,14,15,16,17,18
                if (ten) { // +1
                    now.val = sum - 9; // 0
                } else {
                    now.val = sum - 10; // 0,1,2,3,4,5,6,7,8
                    ten = true;
                }
            }
            l1 = l1.next;
            curr.next = now;
            curr = curr.next;
        }
        while (l2 != null) {
            ListNode now = new ListNode(0);
            int sum = l2.val;
            if (sum < 9) { // 0,1,2,3,4,5,6,7,8
                if (ten) { // +1
                    now.val = sum + 1; // 1,2,3,4,5,6,7,8,9
                } else {
                    now.val = sum; // 0,1,2,3,4,5,6,7,8
                }
                ten = false; // 不进位
            } else if (sum == 9){ // 9
                if (ten) { // +1
                    now.val = 0; // 0
                } else {
                    now.val = sum; // 9
                    ten = false;
                }
            } else { // 10,11,12,13,14,15,16,17,18
                if (ten) { // +1
                    now.val = sum - 9; // 0
                } else {
                    now.val = sum - 10; // 0,1,2,3,4,5,6,7,8
                    ten = true;
                }
            }
            l2 = l2.next;
            curr.next = now;
            curr = curr.next;
        }
        if (ten) {
            curr.next = new ListNode(1);
        }
        return root.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        StringBuilder sb1 = new StringBuilder();
        do {
            sb1.append(l1.val);
            l1 = l1.next;
        } while (l1 != null);

        StringBuilder sb2 = new StringBuilder();
        do {
            sb2.append(l2.val);
            l2 = l2.next;
        } while (l2 != null);

        String s1 = sb1.toString();
        String s2 = sb2.toString();

        StringBuilder sb0 = new StringBuilder();
        String reverseStr = execute(s1, s2, sb0);
        ListNode resultNode = new ListNode(Integer.parseInt(reverseStr.charAt(0) + ""));
        for (int i=1; i<reverseStr.length(); i++) {
            add(resultNode, Integer.parseInt(reverseStr.charAt(i) + ""));
        }
        return resultNode;
    }

    public static void add(ListNode rootNode, int newval) {
        ListNode newNode = new ListNode(newval);
        if(rootNode.next == null)
            rootNode.next = newNode;
        else
            add(rootNode.next, newval);
    }

    private static String execute(String s1, String s2, StringBuilder sb0) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 > length2) {
            boolean c = compute(s1, s2, sb0);
            String newS1 = s1.substring(length2);
            if (c) {
                return execute(newS1, "1", sb0);
            }else {
                return sb0.toString() + newS1;
            }
        } else if (length1 < length2) {
            boolean c = compute(s2, s1, sb0);
            String newS2 = s2.substring(length1);
            if (c) {
                return execute(newS2, "1", sb0);
            } else {
                return sb0.toString() + newS2;
            }
        } else {
            boolean c = compute(s1, s2, sb0);
            if (c) {
                return sb0.toString() + 1;
            } else {
                return sb0.toString();
            }
        }
    }

    private static boolean compute(String s1, String s2, StringBuilder sb0) {
        boolean andOne = false;
        for (int i = 0; i < s2.length(); i++) {
            int c1 = Integer.parseInt(s1.charAt(i) + "");
            int c2 = Integer.parseInt(s2.charAt(i) + "");
            if (andOne) {
                c2 += 1;
            }
            if (c1 + c2 >= 10) {
                sb0.append(c1 + c2 - 10);
                andOne = true;
            } else {
                sb0.append(c1 + c2);
                andOne = false;
            }
            if (i == s2.length() - 1 && andOne) {
                return true;
            }
        }
        return false;
    }
}
