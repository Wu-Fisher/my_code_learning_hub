class Solution472 {
    Set<Long> set = new HashSet<>();
    int p=131;
    int offs=128;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // Arrays.sort(words,(a,b)->a.length()-b.length());
        int n= words.length;
        for(int i=0;i<n;i++)
        {
            if(words[i].length()==0)continue;
            long hash = 0;
            for(char c:words[i].toCharArray())
            {
                hash=hash*p+(c-'a')+offs;
            }
            set.add(hash);
        }
        List<String> ans = new ArrayList<>();
        for(String s : words)
        {
            if(check(s))ans.add(s);
        } 
        return ans;
    }
    public boolean check(String s)
    {
        int  n= s.length();
        int [] f = new int [n+1];
        Arrays.fill(f,-1);
        f[0]=0;
        for(int i=0;i<=n;i++)
        {
            if(f[i]<0)continue;
            long cur = 0;
            for(int j=i+1;j<=n;j++)
            {
                cur= cur*p+(s.charAt(j-1)-'a')+offs;
                if(set.contains(cur)) f[j]=Math.max(f[i]+1,f[j]);
                if(f[n]>1)return true;
            }

        } 
        return false;
    }
}


//字典树的做法
// class Solution472 {
//     Node root= new Node();;
//     public List<String> findAllConcatenatedWordsInADict(String[] words) {
//         int n = words.length;
//         Arrays.sort(words,(a,b)->a.length()-b.length());
//         List<String>ans = new ArrayList<>();
//         for(String s : words)
//         {
//             if(s.length()==0)
//                 continue;
//             if(dfs(s,0))
//             {
//                 ans.add(s);
//             }   
//             else{
//                 insert(s);
//             } 
//         }
//         return ans;
//     }
//     public void insert(String s)
//     {
//         int n= s.length();
//         Node nd=root;
//         for(int i=0;i<n;i++)
//         {
//             char c = s.charAt(i);
//             int index = c-'a';
//             if(nd.next[index]==null)
//             {
//                 nd.next[index]= new Node();
//                 nd=nd.next[index];
//                 if(i==n-1)
//                 {
//                     nd.isEnd=true;
//                 }
//             }
//             else{
//                 nd= nd.next[index];
//             }
//         }
//     }
//     public boolean dfs(String s,int cnt)
//     {
//         if(cnt==s.length())
//             return true;
//         int n= s.length();
//         Node node = root;
//         for(int i=cnt;i<n;i++)
//         {
//              int index= s.charAt(i)-'a';
//              node = node.next[index];
//              if(node==null) return false;
//              if(node.isEnd)
//              {
//                  if(dfs(s,i+1))
//                  {
//                      return true;
//                  }
//              }
//         }
//         return false;
//     }
    
// }

// class Node
// {
//     Node[] next;
//     boolean isEnd;
//     public Node(){
//         next= new Node[26];
//         isEnd=false;
//     }

// }