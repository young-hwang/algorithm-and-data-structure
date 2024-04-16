package _03_mathematics._2480;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 문제
 * 1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다.
 * <p>
 * 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
 * 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
 * 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
 * 예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다.
 * 또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다.
 * 3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.
 * <p>
 * 3개 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램을 작성 하시오.
 * <p>
 * 입력
 * 첫째 줄에 3개의 눈이 빈칸을 사이에 두고 각각 주어진다.
 * <p>
 * 출력
 * 첫째 줄에 게임의 상금을 출력 한다.
 * <p>
 * 예제 입력 1
 * 3 3 6
 * 예제 출력 1
 * 1300
 * 예제 입력 2
 * 2 2 2
 * 예제 출력 2
 * 12000
 * 예제 입력 3
 * 6 2 5
 * 예제 출력 3
 * 600
 */
public class Main {
    private static int sameValue = 0;
    private static int sameCount = 0;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] inputs = reader.readLine().split(" ");
            int[] dices = new int[3];
            for (int i = 0; i < 3; i++) {
                dices[i] = Integer.parseInt(inputs[i]);
            }
            checkSameValue(dices);
            int prize = calcPrize();
            writer.write(String.valueOf(prize));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static int calcPrize() {
        if (sameCount == 3) {
            return 10000 + sameValue * 1000;
        } else if (sameCount == 2) {
            return 1000 + sameValue * 100;
        }
        return sameValue * 100;
    }

    private static void checkSameValue(int[] dices) {
        if (dices[0] == dices[1] && dices[1] == dices[2]) {
            sameValue = dices[0];
            sameCount = 3;
        } else if (dices[0] == dices[1]) {
            sameValue = dices[0];
            sameCount = 2;
        } else if (dices[1] == dices[2]) {
            sameValue = dices[1];
            sameCount = 2;
        } else if (dices[0] == dices[2]) {
            sameValue = dices[0];
            sameCount = 2;
        } else {
            sameValue = max(dices);
            sameCount = 0;
        }
    }

    private static int max(int[] dices) {
        int max = 0;
        for (int i = 0; i < dices.length; i++) {
            if (max < dices[i]) {
                max = dices[i];
            }
        }
        return max;
    }
}
