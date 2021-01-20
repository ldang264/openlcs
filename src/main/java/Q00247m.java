import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * bilibili
 * https://www.bilibili.com/video/BV1ta4y1H7wX?t=82&p=5
 */
public class Q00247m {

    public List<String> helper(int n, int m) {
        // 第一步：判断输入或者状态是否合法
        if (n < 0 || m < 0 || n > m) {
            throw new IllegalArgumentException("Invalid input");
        }
        // 第二步：判断递归是否应当结束
        if (n == 0) return Collections.singletonList("");
        if (n == 1) return Arrays.asList("0", "1", "8");

        // 第三步：缩小问题规模
        List<String> list = helper(n - 2, m);

        // 第四步：整合结果
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != m) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}
