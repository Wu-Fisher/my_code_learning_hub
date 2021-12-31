class Solution846 {
    public boolean isNStraightHand(int[] hand, int m) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue <Integer> q = new PriorityQueue<>((a,b)->a-b);
        for(int i : hand)
        {
            map.put(i,map.getOrDefault(i,0)+1);
            q.add(i);
        }
        while(!q.isEmpty())
        {
            int t = q.poll();
            if(map.get(t)==0) continue;
            for(int i =  0;i<m;i++)
            {
                int cnt=map.getOrDefault(t+i,0);
                if(cnt==0)return false;
                map.put(t+i,cnt-1);
            }
        }
        return true;
    }
}