public class Q01304s {
    public int[] solution(int N) {
        // write your code in Java SE 8
        int[] ans = new int[N];
        int num = 1, idx = (N & 1) == 0 ? 0 : 1;
        while (idx < N) {
            ans[idx++] = num;
            ans[idx++] = -num;
            num++;
        }
        return ans;
    }
}
