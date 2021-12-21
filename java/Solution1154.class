class Solution1154 {
    static int[] nums = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    static int[] f = new int [13];
    static{
            for(int i=1;i<13;i++)
            {
                f[i]=f[i-1]+nums[i-1];
            }
    }
    public int dayOfYear(String date) {
        String[] ss= date.split("-");
        int y=Integer.parseInt(ss[0]);
        int m=Integer.parseInt(ss[1]);
        int d=Integer.parseInt(ss[2]);
        boolean t = (y%4==0&&y%100!=0)||y%400==0; 
        int n= m>2&&t ?f[m-1]+1:f[m-1];
        return n+d;
    }
}