// 动态规划
class Solution42 {
    public int trap(int[] height) {
        int n= height.length;
        int[] l = new int [n];
        int[] r = new int [n];
        l[0]=height[0];
        r[n-1]=height[n-1];
        for(int i= 1;i<n;i++)
        {
            l[i]=Math.max(l[i-1],height[i]);
            r[n-1-i]=Math.max(r[n-i],height[n-1-i]);
        } 
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=Math.min(l[i],r[i])-height[i];
        }
        return ans;
    }
}

//双指针
// class Solution42 {
//     public int trap(int[] height) {
//         int n= height.length;
//         int lmax=0;
//         int rmax=0;
//         int l=0;
//         int r=n-1;
//         int ans=0;
//         while(l<r)
//         {
//             lmax=Math.max(lmax,height[l]);
//             rmax=Math.max(rmax,height[r]);
//             if(height[l]<=height[r])
//             {
//                 ans+=lmax-height[l];
//                 l++;
//             }
//             else
//             {
//                 ans+=rmax-height[r];
//                 r--;
//             }


//         }
//         return ans;
//     }

// }