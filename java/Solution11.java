class Solution11 {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int w=0;
        while(i<j)
        {
            w=height[i]<height[j]?
            Math.max(w,(j-i)*height[i++]):
            Math.max(w,(j-i)*height[j--]);
        }
        return w;
    }
}