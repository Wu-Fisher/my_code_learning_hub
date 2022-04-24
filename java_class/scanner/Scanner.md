# Scanner类
### 基础用法
```java
Scanner scan = new Scanner(System.in);

String str = scan.next();
// or
int num = scan.nextInt();
// or 
String strs = scan.nextLine();

scan.close();
```

### hasNext()

会不断的从输入流中读取数据，直到遇到换行符，

每次读入成功返回true，否则返回false。
```java
Scanner scan = new Scanner(System.in);
while(scan.hasNext()) {
    String str = scan.next();
    // or
    int num = scan.nextInt();
}

```
本方法一次输入多个数据，用空格隔开，然后输入流分别读取

如果没有输入其他数据会等待下一波输入
```shell
>12 13 4324
>12
>13
>4324
>
```

循环结束利用的是循环内部的判断是否读取到正确数据抛出结束，其实是异常的

**处理方法**

① 使用 try catch finally

② 加入参数

```java
Scanner scan = new Scanner(System.in);
        while (!scan.hasNext("#")) {

            int num = scan.nextInt();
            System.out.println(num);

        }
        System.out.println("Sus");

```
当检测到输入 # 的时候就会正常退出

```shell
> 1 2 3
> 1
> 2
> 3
> #
> Sus
```
③ 当你遇到使用hasNextInt()的时候会判断，也可以操作

④ 如果是hasNextLine() 则需要在循环内部加上退出条件

```java
 Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {

            String num = scan.nextLine();
            if (num == "")
                break;
            System.out.println(num);

        }
        System.out.println("Sus");
```
example:

```shell
> 1 2 3 san
> 1 2 3 san
> \n
> Sus 

```
