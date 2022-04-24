class Solution825 {
    public int numFriendRequests(int[] ages) {
        int n=ages.length;
        int ans=0;
        Arrays.sort(ages);
        for(int i=0,j=0,k=0;k<n;k++)
        {
            while(i<k&&!check(ages[i],ages[k]))i++;
            if(j<k)j=k;
            while(j<n&&check(ages[j],ages[k]))j++;
            if(i<j)ans+=j-i-1;

        }
        return ans;
    }
    public boolean check(int x,int y)
    {
        if(y<=0.5*x+7)return false;
        if(y>x)return false;
        if(y>100&&x<100)return false;
        return true;
    }
}