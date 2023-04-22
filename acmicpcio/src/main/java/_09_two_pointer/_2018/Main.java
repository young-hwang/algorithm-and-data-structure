package _09_two_pointer._2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int number = Integer.parseInt(reader.readLine());
            int start = 1;
            int end = 1;
            int count = 1;
            int sum = 1;
            while (start <= number - 1) {
                if (sum < number) {
                    sum += ++end;
                } else if( sum > number) {
                    sum -= start;
                    start++;
                } else if (sum == number) {
                    count++;
                    start++;
                    end = start;
                    sum = start;
                }
            }
            writer.write(String.valueOf(count));
            writer.flush();
        } catch (Exception e) {

        }
    }
}
