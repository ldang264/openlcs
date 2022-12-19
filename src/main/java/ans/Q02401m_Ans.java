package ans;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Q02401m_Ans {
    boolean check(List<String> list, String s, int[] cnt) {
        int n = s.length();
        boolean f = true;
        for (int i = n - 1, j = 0; i >= 0; --i, ++j) {
            if (s.charAt(i) == '1' && cnt[j] == 1) {
                f = false;
                break;
            }
        }
        return f;
    }

    public int longestNiceSubarray(int[] nums) {
        int[] cnt = new int[32];
        List<String> list = new ArrayList<>();
        int maxLen = 0;
        for (int n : nums) {
            list.add(Integer.toBinaryString(n));
        }

        int ans = 1;
        int l = 0, r = 0;
        while (r < nums.length) {
            String s = list.get(r);
            if (check(list,s,cnt)){
                ans= Math.max(ans, r-l+1);
                ++r;
                for (int i = s.length() - 1, j = 0; i >= 0; --i, ++j) {
                    if (s.charAt(i)=='1')cnt[j]=1;
                }
            } else {
                while (!check(list, s,cnt)){
                    String q=list.get(l);
                    for (int i = q.length() - 1, j = 0; i >= 0; --i, ++j) {
                        if (q.charAt(i)=='1')cnt[j]=0;
                    }
                    ++l;
                }
            }
        }
        return ans;
    }
}
