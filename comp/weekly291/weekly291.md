# 291 场周赛

## 题解
<br>

### A （2259）移除指定数字得到的最大结果

网上看到的做法可以直接模拟，对每一个删除的进行排序

我个人的做法的是加入数学法优化（对于权重的理解）

对于当前指针i指向制定数字，当前删除的位置为cur



1：if i<n-1 && nums[i]>nums[i+1], 则可以直接判定ans=i 并返回结果 

2：else cur=i i++ 指针右移


循环结束 ans= cur，返回

简单的想法可以是，我们比较数字大小的时候，可以从高位往低位比较

对于情况1，删除后的第i位会变成nums[i+1],如果选择后面的制定数字，则第i位仍然会是nums[i]，显然是更小的，所以不必再往后寻找

情况2同理分析


<br>
<br>

### B （2260）必须拿起的最小连续卡牌数
哈希表贪心

遍历的过长中，用哈希表储存每一个数字出现的最后一次位置

随后贪心的比较当前数字和上一次出现（或者没有出现过）的距离和当前答案，随后更新哈希表



<br>
<br>

### C （2261）含最多K个可整除元素的子树组

前缀和，哈希表贪心

想到了前缀和，但是没想到哈希表怎么存？（如何判断重复）

利用前缀和得到窗口内能够被p整除的数字个数

后面看题解有人用的是把树组内的元素序列化存在hashset，我很认可

看后续还有没有更好的方法


<br>
<br>

### D （2262）字符串的总引力

有动态规划的意思

从左往右遍历

遍历到i时，此时考虑的子串为[0,i],[1,i],...[i-1,i] 共i个子串

当考虑到s[i]时，如果前面没有出现过s[i]，

则相当于ans+=(s[i-1]考虑的子串引力值之和+i)+1

上一个单位的所有子串（共i个子串）扩充一个s[i]在后面，并且加上s[i]单独作为子串

如果s[i]在之前出现过，且出现位置最近为j，则相当于[0,i-1],[1,i-1],...[j,i-1]加上s[i]后不变，

但是[j+1,i-1],...[i-1,i-1]拼上s[i] 总共 i-j-1个子串引力值+1，然后算上s[i]单独作为子串+1

则ans+=i-j-1+1

<br>
<br>

## 总结

本期感觉很多子数组的题目，有前缀和处理，有动态规划的意思

子数组的判重可以将子数组序列化后存入哈斯表


子数组的遍历除了 

i 0-n : j i-n  s[i:j]之外

还可以为了动态规划从尾巴开始

i 0-n : j 0-i  s[j:i]

复制子数组可以用方法

``` java

int[] copy = Arrays.copyOfRange(nums, i, j);

```

