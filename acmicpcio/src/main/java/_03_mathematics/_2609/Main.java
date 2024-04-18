package _03_mathematics._2609;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 문제
 * 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
 * <p>
 * 출력
 * 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
 * <p>
 * 예제 입력 1
 * 24 18
 * 예제 출력 1
 * 6
 * 72
 */
public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] s = reader.readLine().split(" ");
            var gcd = GCD(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            var lcm = Integer.parseInt(s[0]) * Integer.parseInt(s[1]) / gcd;
            writer.write(String.valueOf(gcd) + "\n");
            writer.write(String.valueOf(lcm));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int GCD(int n1, int n2) {
        int v1 = 0;
        int v2 = 0;
        if (n1 < n2) {
            v1 = n2;
            v2 = n1;
        } else {
            v1 = n1;
            v2 = n2;
        }

        while(v2 != 0) {
            int temp = v1 % v2;
            v1 = v2;
            v2 = temp;
        }
        return v1;
    }
}
