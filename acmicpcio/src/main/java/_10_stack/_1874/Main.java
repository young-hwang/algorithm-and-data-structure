package _10_stack._1874;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(reader.readLine());
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(reader.readLine());
            }
            int num = 1;
            Stack<Integer> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            boolean result = true;
            for (int i = 0; i < N; i++) {
                int v = A[i];
                if (v >= num) {
                    while(v >= num) {
                        stack.push(num++);
                        sb.append("+\n");
                    }
                    stack.pop();
                    sb.append("-\n");
                } else {
                    int n = stack.pop();
                    if (n > v) {
                        result = false;
                        break;
                    } else {
                        sb.append("-\n");
                    }
                }
            }
            if (!result) {
                writer.write("NO");
            } else {
                writer.write(sb.toString());
            }
            writer.flush();
        } catch (Exception e) {

        }
    }
}
