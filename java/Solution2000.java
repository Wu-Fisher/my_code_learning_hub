class Solution2000 {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if(idx>=0)
        {
            char[] cs = word.toCharArray();
            int l = 0;
            int r = idx;
            while(l<r)
            {
                char temp = cs[l];
                cs[l]=cs[r];
                cs[r]=temp;
                l++;
                r--;
            }
            word =  new String(cs);
        }
        return word;
    }
}