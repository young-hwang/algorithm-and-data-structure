package _18_topology_sort._2252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(token.nextToken());
            ArrayList[] list = new ArrayList[N + 1];
            int[] inDegree = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList();
            }
            for (int i = 0; i < M; i++) {
                StringTokenizer edge = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(edge.nextToken());
                int b = Integer.parseInt(edge.nextToken());
                list[a].add(b);
                inDegree[b]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()) {
                Integer node = queue.poll();
                writer.write(node + " ");
                for (int i = 0; i < list[node].size(); i++) {
                    int next = (int) list[node].get(i);
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
