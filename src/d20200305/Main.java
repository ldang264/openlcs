package d20200305;

public class Main {

    public static void main(String[] args) {
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

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println("result:" + listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

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
