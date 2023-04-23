package _09_two_pointer._1940;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(reader.readLine());
            int M = Integer.parseInt(reader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int[] items = new int[N];
            for (int i = 0; i < N; i++) {
                items[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Arrays.sort(items);
            int start = 0;
            int end = N - 1;
            int sum = 0;
            int count = 0;
            while(start < end) {
                sum = items[start] + items[end];
                if (sum < M) {
                    start++;
                } else if (sum > M) {
                    end--;
                } else if (sum == M) {
                    count++;
                    start++;
                    end--;
                }
            }
            writer.write(String.valueOf(count));
            writer.flush();
        } catch (Exception e) {

        }
    }
}
