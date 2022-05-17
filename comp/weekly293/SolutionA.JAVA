class SolutionA {
    public List<String> removeAnagrams(String[] words) {
        String pre="";
        List<String> ans=new ArrayList<>();
        for(String s:words){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String x = String.valueOf(cs);
            if(!x.equals(pre))
            {
                ans.add(s);
                pre=x;
            }
        }
        return ans;
    }
}