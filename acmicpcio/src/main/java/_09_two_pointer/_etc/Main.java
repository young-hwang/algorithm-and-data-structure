package _09_two_pointer._etc;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * input
 * teachermode e
 *
 * output
 * 1 0 1 2 1 0 1 2 2 1 0
 */
public class Main {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String[] input = reader.readLine().split(" ");
            char[] s = input[0].toCharArray();
            char m = input[1].charAt(0);
            int[] result = new int[s.length];

            for (int i = 0; i < s.length; i++) {
                if (s[i] == m) {
                    result[i] = 0;
                    continue;
                }
                int min = 0;
                for (int j = 1; j < s.length; j++) {
                    if (i + j < s.length && s[i + j] == m) {
                        min = j;
                        break;
                    }
                    if (i - j >= 0 && s[i - j] == m) {
                        min = j;
                        break;
                    }
                }
                result[i] = min;
            }

            for (int i = 0; i < result.length; i++) {
                writer.write(String.valueOf(result[i]) + " ");
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
