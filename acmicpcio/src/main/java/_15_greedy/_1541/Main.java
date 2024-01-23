package _15_greedy._1541;

import java.util.Scanner;

/*
N: 수식
SUM: 합계
- 를 기준으로 괄호 사용
- 뒤 숫자를 모두 뺀다
A: - 기준으로 나눈 수식
A[0] - A[1] - A[2] - ... - A[n]
 */
public class Main {
    public static void main(String[] args) {
        String N;
        int SUM = 0;
        Scanner scanner = new Scanner(System.in);
        N = scanner.next();
        String[] A = N.split("-");
        for (int i = 0; i < A.length; i++) {
            String[] split = A[i].split("\\+");
            int temp = 0;
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("")) {
                    continue;
                }
                temp += Integer.parseInt(split[j]);
            }
            if (i == 0) {
                SUM = temp;
            } else {
                SUM -= temp;
            }
        }
        System.out.println(SUM);
    }
}
