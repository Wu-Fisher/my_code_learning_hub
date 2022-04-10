

## tips

    1.有时Integer.Max_INT可能会在操作的时候不小心+1变成最小，可以用0x3f3f3f3f替代


## 比较：
    1.c=Math.min or *.max(a,b) ;

## Array
    1.array_length=array.length;


## ArrayList
    1.List<*> arr= new ArrayList<>();
    2.arr_length=arr.add();   str.append(strx)=str+strx
    3.Arrays.fill(arr,0);
    4.arr.size()
    5.arr.remove(index)
    6.arr.set(index,change)
    7.Collection.sort(arr) shengxu
    8.arr.subList(a,b) 左开右闭   str.substring(a,b)类似
    9.arr.toArray(new Object[size])转为数组
## Set
    **去重

    1.Set<*> set = new HashSet<>();
    2.set.add(object);
    3.set_length=set.size();

## HashMap
    1.Map<*,*> map= new HashMap<>();
    2.map.put(*,*);
    3.map.size();

    4.keySet() 返回所有key值 get(key) 返回key值value values()返回所有value
    5.containsKey()	检查 hashMap 中是否存在指定的 key 对应的映射关系。
      containsValue()检查 hashMap 中是否存在指定的 value 对应的映射关系。
    6.getOrDefault(key,setnum)	获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值
    7.entrySet()	返回 hashMap 中所有映射项的集合集合视图。
        for(Entry<String, Integer> entry: numbers.entrySet())
    8.map.isEmpty();
    9.特殊生成方式
            Map<String,String[]> map= new HashMap<>(){
                {
              put("2", new String[]{"a", "b", "c"});
            put("3", new String[]{"d", "e", "f"});
            put("4", new String[]{"g", "h", "i"});
            put("5", new String[]{"j", "k", "l"});
            put("6", new String[]{"m", "n", "o"});
            put("7", new String[]{"p", "q", "r", "s"});
            put("8", new String[]{"t", "u", "v"});
            put("9", new String[]{"w", "x", "y", "z"});                  
                }
            };
    10. 
    Map<Integer, List<Integer>> map = new HashMap<>();
    map.computeIfAbsent(arr[i], t -> new ArrayList<>()).add(i);
## Deque
    1.Deque<*> d= new ArrayDeque<>();
    2.o=d.peekLast(); 返回最右端
    3.o=d.pollLast(); 弹出并返回最右端
    4.d.add(object);

## PriorityQueue

    1.PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[2]-b[2]); 建立小根堆

    2.PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Double.compare(b[0]*1.0/b[1],a[0]*1.0/a[1]));
            建立大根堆，且利用Double.compare()函数比较大小

## char
    1.String s, s.toCharArray()返回一个字符数组
    2.Character.isLetter(c) 判断c是否是字母
    3.Character.toLowerCase(c) 如果c为大写字母，返回他的小写，如果是小写则不变
    4.String.valueOf(cs) cs为字符串数组， 

## Scanner

    scan.nextInt();
    scan.nextLine();
    
