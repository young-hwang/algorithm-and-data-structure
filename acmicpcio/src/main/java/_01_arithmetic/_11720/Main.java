package _01_arithmetic._11720;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String first = reader.readLine();
            String second = reader.readLine();

            int size = Integer.parseInt(first);
            char[] charArray = second.toCharArray();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                sum += charArray[i] - 48;
            }

            writer.write(String.valueOf(sum));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
