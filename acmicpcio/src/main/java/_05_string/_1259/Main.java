package _05_string._1259;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 문제
 * 어떤 단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 한다.
 * 'radar', 'sees'는 팰린드롬이다.
 * 수도 팰린드롬으로 취급할 수 있다. 수의 숫자들을 뒤에서부터 읽어도 같다면 그 수는 팰린드롬수다. 121, 12421 등은 팰린드롬수다. 123, 1231은 뒤에서부터 읽으면 다르므로 팰린드롬수가 아니다. 또한 10도 팰린드롬수가 아닌데, 앞에 무의미한 0이 올 수 있다면 010이 되어 팰린드롬수로 취급할 수도 있지만, 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자.
 *
 * 입력
 * 입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 줄마다 1 이상 99999 이하의 정수가 주어진다. 입력의 마지막 줄에는 0이 주어지며, 이 줄은 문제에 포함되지 않는다.
 *
 * 출력
 * 각 줄마다 주어진 수가 팰린드롬수면 'yes', 아니면 'no'를 출력한다.
 *
 * 예제 입력 1
 * 121
 * 1231
 * 12421
 * 0
 * 예제 출력 1
 * yes
 * no
 * yes
 */
public class Main {
    public static void main(String[] args) {
        // 1. 입력을 받는다.
        // 2. 입력이 0이면 종료한다.
        // 3. 입력을 뒤집어서 같은지 비교한다.
        // 4. 같으면 yes, 다르면 no를 출력한다.
        StringBuilder results = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            while(true) {
                char[] input = reader.readLine().toCharArray();
                if (input[0] == '0') {
                    break;
                }
                int result = 1;
                for (int i = 0; i < input.length / 2; i++) {
                    if (input[i] != input[input.length - 1 - i]) {
                        result = 0;
                        break;
                    }
                }
                if (result == 1) {
                    results.append("yes\n");
                } else {
                    results.append("no\n");
                }
            }
            writer.write(results.toString());
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
