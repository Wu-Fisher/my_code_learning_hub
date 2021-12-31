class Solution488 {
    int INF=  0x3f3f3f3f;
    int m;
    String b;
    Map<String , Integer> map = new HashMap<>();
    public int findMinStep(String a, String _b) {
        b=_b;
        m=b.length();
        //这里第二个参数 0 和题解里的1<<m 都可以
        int ans=dfs(a,0);
        return ans==INF?-1:ans;
    }
    int dfs(String a,int cur)
    //a 为当前插入的字符串
    //cur 为二进制数，为已经使用插入的hand（b），
    //这里用int保存和位运算操作，是为了降低时间。
    {
        if(a.length()==0)return 0;
        if(map.containsKey(a)) return map.get(a);
        //广度搜索提取之前已经计算过的结果节约时间
        int ans = INF;
        int n =  a.length();
        for(int i=0;i<m;i++)
        //该循环选择使用hand中的哪一个
        {
            
            if(((cur>>i)&1)==1)continue;
            //如果第i位被已经被使用，则跳过
            int next = (1<<i)|cur;
            //修改下一次cur的值，使用第i个
            for(int j=0;j<=n;j++)
            //这个循环判断插入在哪个位置
            {
                boolean ok = false;
                //自己与插入位置的颜色不相同，但是可以插在两个相同颜色的中间
                // 例如 RRWWRRBBRR 和 WB 这个测试用例：
                // 正确答案是在最后两个R中插入一个W，其他解决方案都会剩下两个字母没法消除。
                if(j>0&&j<n&&a.charAt(j)==a.charAt(j-1)&&a.charAt(j-1)!=b.charAt(i))
                    ok = true;
                //插入位置和自己颜色一样
                if(j<n&&a.charAt(j)==b.charAt(i))
                    ok= true;
                if(!ok) continue;
                StringBuilder sb = new StringBuilder();
                sb.append( a.substring(0,j)).append(b.substring(i,i+1));
                if(j!=n)sb.append(a.substring(j));
                int k=j;
                //从插入改变位置中心左右扩散，判断有没有可以删除的
                while(0<=k && k< sb.length())
                {
                    char c = sb.charAt(k);
                    int l=k,r=k;
                    while(l>=0 && sb.charAt(l)==c)l--;
                    while(r<sb.length()&&sb.charAt(r)==c)r++;
                    if(r-l-1>=3)
                    {
                        sb.delete(l+1,r);
                        k=l>=0?l:r;
                    }
                    else{
                        break;
                    }
                }
                //
                ans = Math.min(ans,dfs(sb.toString(),next)+1);

            }
        }
        map.put(a,ans);
        return ans;
    }
}