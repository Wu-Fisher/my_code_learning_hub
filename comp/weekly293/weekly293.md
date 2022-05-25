# 293 场周赛

## 题解
<br>

### A （2273） 移除字母异位词后的结果数组

如题，并且只会删去连续的异位并且保留第一个

可以简单模拟加字母频率统计

乐看到一个好做法，直接对每一个单词内部字母进行排序，相当于直接统一顺序之后，可以异步的就会相同，每一次比较和前一个是否相同，如果不同则加入结果数组


<br>
<br>

### B (2274) 不含特殊楼层的最大连续楼层数

首先肯定是将特殊楼层先排序

-=- 结果直接遍历就好了，把开始和结束特殊处理一下（因为算作普通楼层） 就块接近双百了

<br>
<br>

### C (2275) 按位与结果大于零的最长组合

找出子数组中，全部按位与后大于0最大的子数组

这个其实就得看，原数组中，哪个位置上的1的数量最多，而这个数量就是子数组的数量

此时按位与一定会大于0,并且可以想到如果结果不为0，则所有数字里面必然有一个位上全为1，否则矛盾

<br>
<br>

### D (2276) 统计区间中的整数数目

从一个空的数据结构中，每次添加一个区间内连续的所有整数

另外一个函数用于返回至少存在在一个之前提供区间的整数的数目

可以用优化后的线段树

或者是新看到的[珂朵莉树 odt](https://oi-wiki.org/ds/odt/)

用一个节点来维护一个区间

本体用的是一课平衡树，树里是不相交的区间，平衡树key为右端点，value为左端点，我们要找第一个key>=left的区间

然后将这个区间的覆盖到的所有小区间都踢出，并且删除计数

注意如果新区间的边界值在原来已有区间的中间的话（假设l为找出区间的左边界，left为你一开始add的，left > l），也要删除该区间 并且要改 left 为 l ，删除计数仍然是 l-r+1 （最后r和 right同理）

最后停止的可以是 ceilingEntry 当前的left找到第一个最近的r的左边界l > right 则没有交叉，或者是直接返回null

（包括更新后left right覆盖的合并为一个新的大区间再加入树）




返回平衡树中不小于key的最接近节点

``` java

var e = TreeMap.ceilingEntry(KEY);

```