import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {

            String num = scan.nextLine();
            if (num == "")
                break;
            System.out.println(num);

        }
        System.out.println("Sus");
    }
}