# IO class

先放张图表示一下，大概就清晰了类关系，

**字节字符有极强的对应关系**

![](/draw/io.png)

## 常用范例
**实际写法throws都应该按照实际逻辑改为try catch**

### 创建文件
```java

// 不会创建新文件
File file = new File("a.txt");

// 如果要创建新文件
file.createNewFile();
```



### 一行一行写入/读取
主要利用bufferW/R
``` java
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("b.txt");
        // BufferedWriter bw = new BufferedWriter(fw);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("b.txt")));
        bw.write("Hello\n");
        bw.write("World\n");
        bw.flush();
        bw.close();
        FileReader fr = new FileReader("b.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
```

### 读写对象
```java
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
        User user = new User("zhangsan", 20);
        oos.writeObject(user);
        user = new User("lisi", 30);
        oos.writeObject(user);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
        User u = null;
        while ((u = (User) ois.readObject()) != null) {
            System.out.println(u.getName() + " " + u.getAge());
        }
        ois.close();

    }


```