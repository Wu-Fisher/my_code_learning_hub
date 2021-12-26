class Solution2109 {
    public String addSpaces(String s, int[] spaces) {
            StringBuilder sb = new StringBuilder();
            int j=spaces.length-1;
            int n=s.length();
             for(int i=n-1;i>=0;i--)
             {
                sb.append(s.charAt(i));
                if(j>=0&&i==spaces[j])
                {
                    sb.append(" ");
                    j--;
                }
             }
             return sb.reverse().toString();
    }
}