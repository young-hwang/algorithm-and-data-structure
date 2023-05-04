package _11_queue._11286;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(reader.readLine());
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
                int o1abs = Math.abs(o1);
                int o2abs = Math.abs(o2);
                if (o1abs == o2abs) {
                    return o1 > o2 ? 1 : -1;
                }
                return o1abs - o2abs;
            });
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(reader.readLine());
                if (n == 0) {
                    if (queue.isEmpty()) {
                        writer.write("0\n");
                    } else {
                        writer.write(String.valueOf(queue.poll()));
                        writer.write("\n");
                    }
                } else {
                    queue.add(n);
                }
            }
            writer.flush();
        } catch (Exception e) {

        }
    }
}
