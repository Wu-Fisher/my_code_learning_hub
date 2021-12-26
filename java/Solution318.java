class Solution318 {
    public int maxProduct(String[] words) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(String w: words)
        {
            int t=0;
            for(int i =0;i<w.length();i++)
            {
                int u= w.charAt(i)-'a';
                t|=(1<<u);
            }
            if(!map.containsKey(t)||map.get(t)<w.length())map.put(t,w.length());
        }
        int ans=0;
        for(int a: map.keySet())
        {
            for(int b : map.keySet())
            {
                if((a&b)==0)ans= Math.max(ans,map.get(a)*map.get(b));
            }
        }
        return ans;
    }
}