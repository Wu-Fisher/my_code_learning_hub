package hub_repo.my_leetcode_learning_hub.java;

import java.util.ArrayList;

class Solution1078 {
    public String[] findOcurrences(String text, String first, String second) {
            String[] ss = text.split(" ");
            int n=ss.length;
            ArrayList<String> sb = new ArrayList<>();
            for(int i=0;i+2<n;i++)
            {
                if(ss[i].equals(first)&&ss[i+1].equals(second))
                    sb.add(ss[i+2]);
            }
            return sb.toArray(new String[sb.size()]);
    }
}