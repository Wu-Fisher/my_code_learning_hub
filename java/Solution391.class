class Solution391 {
    public boolean isRectangleCover(int[][] rectangles) {
        int n= rectangles.length;
        int[][]rs = new int[2*n][4];
        //rs[0]=边x坐标，rs[1]=边y上点,rs[2]=边y下点
        //rs[3]=1为左边，-1为右边
        for(int i=0,idx=0;i<n;i++)
        {
            int []re=rectangles[i];
            rs[idx++]=new int[]{re[0],re[1],re[3],1};
            rs[idx++]=new int[]{re[2],re[1],re[3],-1};
        
        }
        //排序，如果边x轴不一样，按x升序列；若x相同，按边y上界升序
        Arrays.sort(rs,(a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            return a[1]-b[1];
        });
        n*=2;
        //建立两个list分别保存同一个x坐标下的左右边
        List<int[]>l1= new ArrayList<>();
        List<int[]>l2= new ArrayList<>();
        for(int l=0;l<n;)
        {
            int r=l;
            l1.clear();
            l2.clear();
            while(r<n&&rs[r][0]==rs[l][0])r++;
            for(int i=l;i<r;i++)
            {
                int[]cur = new int[]{rs[i][1],rs[i][2]};
                List<int[]>list= rs[i][3]==1?l1:l2;
                if(list.isEmpty())
                {
                    list.add(cur);
                }
                else{

                    int[]prev= list.get(list.size()-1);
                    //当重合直接返回false
                    if(cur[0]<prev[1])return false;
                    //**当首尾相接，直接拼接在一起**
                    else if(cur[0]==prev[1])prev[1]=cur[1];
                    else list.add(cur);
                }
            }
            //当边为非边界边时
            if(l>0&&r<n){
                if(l1.size()!=l2.size())return false;
                for(int i=0;i<l1.size();i++)
                {
                    if(l1.get(i)[0]==l2.get(i)[0]&&l1.get(i)[1]==l2.get(i)[1])continue;
                    return false;
                }
            }//边为边界边，必须首尾相接并且为一条边
            else{
                if(l1.size()+l2.size()!=1)return false;
            }
            //此时r在上面的处理已经为下一个x坐标的第一个
            l=r;
        }
        return true;
    }
}