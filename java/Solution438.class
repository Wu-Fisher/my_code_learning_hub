class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
            ArrayList <Integer> ans= new ArrayList<>();
            int n= s.length();
            int m= p.length();
            int []cnt=new int[26];
            for(int i=0;i<m;i++) cnt[p.charAt(i)-'a']++;
            int a=0;
            for(int i=0;i<26;i++)
            {
                if(cnt[i]!=0) a++;
            }
            int b=0;
            for(int l=0,r=0;r<n;r++)
            {
                if(--cnt[s.charAt(r)-'a']==0) b++;
                if(r-l+1>m&&++cnt[s.charAt(l++)-'a']==1) b--;
                if(a==b) ans.add(l);
            }
            return ans;

    }
}