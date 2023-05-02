package _11_queue._2164;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(reader.readLine());
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                queue.add(i);
            }
            while (queue.size() > 1) {
                queue.poll();
                queue.add(queue.poll());
            }
            writer.write(String.valueOf(queue.poll()));
            writer.flush();
        } catch (Exception e) {

        }
    }
}
