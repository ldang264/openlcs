package q00899h_todo;

public class OrderlyQueue {
    public static void main(String[] args) {
        OrderlyQueue main = new OrderlyQueue();
        System.out.println(main.orderlyQueue("cba", 1));
        System.out.println(main.orderlyQueue("baaca", 3));
        System.out.println(main.orderlyQueue("bacab", 3));
        System.out.println(main.orderlyQueue("hmg", 2));
        System.out.println(main.orderlyQueue("dbcea", 2));
        System.out.println(main.orderlyQueue("xmvzi", 2));
    }

    public String orderlyQueue(String S, int K) {
        if (1 == S.length()) {
            return S;
        }
        if (K == 1) {
            return handleOne("", S);
        } else {
            int minIndex = findMinIndex(S);
            return loop("", minIndex == 0 ? S : S.substring(minIndex) + S.substring(0, minIndex), K);
        }
    }

    private String loop(String sorted, String S, int K) {
        if (K == 1) {
            return handleOne(sorted, S);
        }
        String before = S.substring(0, K);
        int beforeMinIndex = findMinIndex(before);
        while(beforeMinIndex > 0) {
            S = S.substring(beforeMinIndex) + S.substring(0, beforeMinIndex);
            before = S.substring(0, K);
            beforeMinIndex = findMinIndex(before);
        }
        return loop(sorted + S.substring(0, 1),  S.substring(1), K-1);
    }

    private String handleOne(String sorted, String left) {
        int minIndex = findMinIndex(left);
        if (minIndex > 0) {
            return sorted + left.substring(minIndex, left.length()) + left.substring(0, minIndex);
        } else {
            return sorted + left;
        }
    }

    /**
     * 找到最小的字符位置
     * @param s
     * @return char
     */
    private int findMinIndex(String s) {
        int index = 0;
        char min = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current < min) {
                min = current;
                index = i;
            }
        }
        return index;
    }

}
