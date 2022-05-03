import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

public class Solution937 {

    class Log {
        int type;
        int idx;
        // ori 为原始字符串
        // sign 为标记字符串
        // context 为内容字符串
        // type 为内容的类型
        String ori, sign, context;

        Log(String s, int _idx) {
            idx = _idx;
            int n = s.length();
            int i = 0;
            while (i < n && s.charAt(i) != ' ')
                i++;
            sign = s.substring(0, i);
            context = s.substring(i + 1);
            ori = s;
            type = Character.isDigit(context.charAt(0)) ? 1 : 0;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        List<Log> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Log(logs[i], i));
        }
        Collections.sort(list, (a, b) -> {
            if (a.type != b.type)
                return a.type - b.type;
            else if (a.type == 1)
                return a.idx - b.idx;
            else
                return !a.context.equals(b.context) ? a.context.compareTo(b.context) : a.sign.compareTo(b.sign);

        });
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i).ori;
        }
        return ans;
    }

}
