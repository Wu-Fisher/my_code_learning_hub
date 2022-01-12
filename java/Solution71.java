class Solution71 {
    public String simplifyPath(String path) {
        Deque <String>  d = new ArrayDeque<>();
        int n = path.length();
        for(int i = 1 ;i<n;)
        {
            if(path.charAt(i)=='/'&&++i>=0)continue;
            int j=i+1;
            while(j<n&&path.charAt(j)!='/')j++;
            String cur = path.substring(i,j);
            if(cur.equals(".."))
            {
                if(!d.isEmpty())d.pollLast();
            }
            else if (!cur.equals("."))
            {
                d.addLast(cur);
            }
            i=j;
        }
        StringBuilder sb = new StringBuilder();
        while(!d.isEmpty())sb.append("/"+d.pollFirst());
        return sb.length()==0?"/":sb.toString();
    }
}