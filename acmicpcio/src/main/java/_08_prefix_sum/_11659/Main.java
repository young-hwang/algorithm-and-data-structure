package _08_prefix_sum._11659;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        int arraySize = 0;
        int questionCount = 0;

        try(
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            // 기준 읽기
            String first = reader.readLine();
            String[] values = first.split(" ");
            arraySize = Integer.parseInt(values[0]);
            questionCount = Integer.parseInt(values[1]);

            // 숫자 배열 읽기
            String second = reader.readLine();
            String[] questions = new String[questionCount];

            // 합계 질문 읽기
            for (int i = 0; i < questionCount; i++) {
                questions[i] = reader.readLine();
            }

            int[] preSumNumbers = getPreSumNumbers(arraySize, second);

            // 질문에 답 출력
            for (int i = 0; i < questionCount; i++) {
                writer.write(String.valueOf(getPreSum(preSumNumbers, questions[i])));
                writer.write("\n");
            }
            writer.flush();
        } catch (Exception e) {

        }
    }

    private static int getPreSum(int[] preSumNumbers, String question) {
        String[] questionValues = question.split(" ");
        int startIndex = Integer.parseInt(questionValues[0]) - 1;
        int endIndex = Integer.parseInt(questionValues[1]) - 1;
        if (startIndex == 0) {
            return preSumNumbers[endIndex];
        }
        return preSumNumbers[endIndex] - preSumNumbers[startIndex - 1];
    }

    private static int[] getPreSumNumbers(int arraySize, String second) {
        String[] sNumbers = second.split(" ");
        int[] preSumNumbers = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            if (i == 0) {
                preSumNumbers[i] = Integer.parseInt(sNumbers[i]);
                continue;
            }
            preSumNumbers[i] = preSumNumbers[i - 1] + Integer.parseInt(sNumbers[i]);
        }

        return preSumNumbers;
    }
}
