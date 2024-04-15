package _03_mathematics._11382;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제
 * 꼬마 정민이는 이제 A + B 정도는 쉽게 계산할 수 있다. 이제 A + B + C를 계산할 차례이다!
 * <p>
 * 입력
 * 첫 번째 줄에 A, B, C (1 ≤ A, B, C ≤ 1012)이 공백을 사이에 두고 주어진다.
 * <p>
 * 출력
 * A+B+C의 값을 출력한다.
 * <p>
 * 예제 입력 1
 * 77 77 7777
 * 예제 출력 1
 * 7931
 */
public class Main {
    public static void main(String[] args) {
        try (var reader = new BufferedReader(new InputStreamReader(System.in));
             var writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
            long sum = 0;
            while (token.hasMoreTokens()) {
                sum += Long.parseLong(token.nextToken());
            }
            writer.write(String.valueOf(sum));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
