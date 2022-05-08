# Scanner类
### 基础用法
```java
Scanner scan = new Scanner(System.in);

String str = scan.next();
// or
int num = scan.nextInt();
// or 
String strs = scan.nextLine();

// 删除字符串头尾的做法
strs.trim();

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
⑤ 还可以ctrl + z 输入EOF 停止读入

！ 貌似OJ平台给的输入如果不给矩阵大小，好像这里可以直接不用判断循环条件

问题在：[转载学习](https://marshzero.github.io/2021/03/17/Java%E8%BE%93%E5%85%A5%E8%BE%93%E5%87%BA%E6%96%B9%E6%B3%95%E6%80%BB%E7%BB%93/)

当匹配到时，例如当前位置为\n，或者当前位置为有效字符，但有效字符后由结束符(\n或\r或\n\r或\r\n)，hasNextLine()会返回true；

hasNext 类似，都会等待下一波输入从而无法停止

但是oj里面的数据，最后没有带\n，就不会等待下一次输入

``` java
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            System.out.println(a+b);
        }
    }
}

用例：
1 5
10 20
scan.buf:"1 5\n10 20"
```