class Solution717 {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int idx=0;
        while(idx<n-1)
        {
            if(bits[idx]==0)idx++;
            else idx+=2;

        }
        return idx==n-1;
    }
}