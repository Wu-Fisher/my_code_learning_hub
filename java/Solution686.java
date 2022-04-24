class Solution686 {
    public int repeatedStringMatch(String a, String b) {
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        while(sb.length()<b.length()&&++ans>0)sb.append(a);
        //上届这里需要+1
        sb.append(a);
        int i = sb.indexOf(b);
        if(i==-1)return -1;
        else return (i+b.length())>a.length()*ans?ans+1:ans ;

    }
}