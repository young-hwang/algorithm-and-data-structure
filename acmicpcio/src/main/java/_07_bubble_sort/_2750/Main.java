package _07_bubble_sort._2750;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(reader.readLine());
            int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(reader.readLine());
            }
            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < N - 1 - i; j++) {
                    if (numbers[j] > numbers[j+1]) {
                        int tmp = numbers[j+1];
                        numbers[j+1] = numbers[j];
                        numbers[j] = tmp;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                writer.write(String.valueOf(numbers[i]) + "\n");
            }
            writer.flush();
        } catch (Exception e) {

        }
    }
}
