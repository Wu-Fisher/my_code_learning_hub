class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnt=getCnt(licensePlate);
        String ans=null;
        for(String s:words)
        {   
            boolean ok= true;
            int[] cur = getCnt(s);
            for(int i=0;i<26;i++)
            {
                if(cur[i]<cnt[i]) ok=false;

            }
            if(ok&&(ans==null||s.length()<ans.length()))ans=s;
        }
        return ans;
        
        }

    public int[] getCnt(String s)
    {
        int []cnt = new int[26];
        for(char c: s.toCharArray())
        {
            if(Character.isLetter(c))
            {
                cnt[Character.toLowerCase(c)-'a']++;
            }
        }
        return cnt;
    }
}