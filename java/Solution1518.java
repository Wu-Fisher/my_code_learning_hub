class Solution1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
           int n=numBottles/(numExchange-1);
           return (numBottles%(numExchange-1)==0)?n+numBottles-1:n+numBottles;

    }
}




// //模拟
// class Solution1518 {
//     public int numWaterBottles(int numBottles, int numExchange) {
//             int a=numBottles;
//             int b=0;
//             int ans=a;
//             while(a>=numExchange)
//             {
//                 b=a/numExchange;
//                 a%=numExchange;
//                 a+=b;
//                 ans+=b;
//             }
//             return ans;

//     }
// }