class Solution507 {
    public boolean checkPerfectNumber(int num) {
        if(num==1)return false;
        int ans=1;
        for(int i=2;i<=num/i;i++)

        {
            if(num%i==0)
            {ans+=i;
            if ((i*i)!=num) {
                    ans += num / i;
                }
            }
        }
        return ans==num;
    }
}