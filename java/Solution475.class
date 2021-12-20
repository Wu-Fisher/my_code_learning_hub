class Solution475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l=0;
        int r=(int)1e9;
         while (l<r)
         {
             int mid= (l+r)>>1;
             if(check(houses,heaters,mid)) r=mid;
             else l=mid+1;
         }
        return r;
    }
    public boolean check(int []houses, int[] heaters,int x)
    {
        int n=houses.length;
        int m=heaters.length;
        for(int i=0,j=0;i<n;i++)
        {
            while(j<m&&houses[i]>heaters[j]+x)j++;
            if(j<m&&houses[i]>=heaters[j]-x&&houses[i]<=heaters[j]+x)continue;
            return false;
        }
        return true;
    }
}