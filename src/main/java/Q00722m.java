import java.util.ArrayList;
import java.util.List;

public class Q00722m {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String s : source) {
            sb.append(s).append('\'');
        }
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '/') {
                if (sb.charAt(i + 1) == '/') {
                    sb.replace(i, sb.indexOf("'", i + 2), ""); // 找到行分隔符'
                } else if (sb.charAt(i + 1) == '*') {
                    sb.replace(i, sb.indexOf("*/", i + 2) + 2, ""); // 找到块结束标志*/
                    i--;
                }
            }
        }
        for (String s : sb.toString().split("'")) {
            if (s.length() > 0) {
                ans.add(s);
            }
        }
        return ans;
    }
}
