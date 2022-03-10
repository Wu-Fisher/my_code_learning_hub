package test;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Question1 {
    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        // // 在此输入您的代码...
        // scan.close();
        int n = 2022;
        int[] q = new int[n];
        q[1] = 0;
        for (int i = 2; i < n; i++) {
            q[i] = Integer.MAX_VALUE;

        }
        for (int i = 1; i <= 2020; i++) {
            for (int j = i + 1; j <= 2021 && (j - i) <= 21; j++) {
                q[j] = Math.min(q[j], q[i] + le(i, j));

            }
        }
        System.out.println(q[2021]);
    }

    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static int le(int a, int b) {
        return a * b / gcd(a, b);
    }
}