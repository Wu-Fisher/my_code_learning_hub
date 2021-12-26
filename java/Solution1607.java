class Solution1607 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int x=location.get(0);
        int y=location.get(1);
        List<Double> list = new ArrayList<>();
        int cnt=0;
        double pi=Math.PI;
        double t=pi*angle/180;

        for(List<Integer> p : points)
        {
            int a= p.get(0);
            int b= p.get(1);
            if(a==x&&b==y&&++cnt>=0)
            {
                continue;
            }
            else{
                list.add(Math.atan2(b-y,a-x));
            }
        }
        Collections.sort(list);
        int n= list.size();
        for(int i=0;i<n;i++)
        {
            list.add(list.get(i)+2*pi);
        }
        int max=0;
        for(int i=0,j=0;j<2*n;j++)
        {
            while(i<j&&(list.get(j)-list.get(i))>t) i++;
            max=Math.max(max,j-i+1);
        }
            return max+cnt;

    }
}