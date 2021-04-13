package tool;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while (curr != null) {
            sb.append(',').append(curr.val);
            curr = curr.next;
        }
        return sb.length() > 0 ? sb.substring(1) : "";
    }

    public static ListNode deserialize(String data) {
        if (data == null) return null;
        String[] arr = data.split(",");
        ListNode hair = new ListNode(-1);
        ListNode ch = hair;
        for (String s : arr) {
            ListNode curr = new ListNode(Integer.parseInt(s.trim()));
            ch.next = curr;
            ch = curr;
        }
        return hair.next;
    }
}
