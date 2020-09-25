package q00002;

public class ListNode {
    int val;

    ListNode next;

    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        if (next == null) {
            return "" + val;
        }
        return val + next.toString();
    }
}
