class TopVotedCandidate911 {
    List<int[]> list = new ArrayList<>();
    public TopVotedCandidate(int[] persons, int[] times) {
        int val=0;
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<times.length;i++)
        {
            map.put(persons[i],map.getOrDefault(persons[i],0)+1);
            if(map.get(persons[i])>=val)
            {
                val=map.get(persons[i]);
                list.add(new int[]{times[i],persons[i]});
            }
        }
    }
    
    public int q(int t) 
    {
        int l=0;
        int r=list.size()-1;
        while(l<r)
        {
            //这里+1很重要，防止mid一开始等于l，然后不小心死循环
            int mid=(l+r+1)/2;
            if(list.get(mid)[0]<=t)l=mid;
            else r=mid-1;
        }
        return list.get(r)[0]<=t?list.get(r)[1]:0;



    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */