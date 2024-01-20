package _12_dfs._11724;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) {
        /*
        n : 정점의 개수 (1 <= n <= 1,000), m : 간선의 개수 (1 <= m <= 10,000)
        A : 그래프 데이터 저장 인접 리스트
        visited : 방문 기록 저장 배열
        c : 연결 요소의 개수
        for i : 1 ~ n
           A 인접 리스트의 각 ArrayList 초기화
        for i : 1 ~ m
           A 인접 리스트에 그래프 데이터 저장
        for i : 1 ~ n
           if (방문하지 않은 노드가 있으면)
              c++
           dfs(i)

        dfs {
            if (현재 노드 == 방문한 노드) return
            visited 방문 기록 저장
            현재 연결된 노드 중 방문하지 않은 노드로 dfs 실행
          }
        }
        */

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // n : 정점의 개수 (1 <= n <= 1,000), m : 간선의 개수 (1 <= m <= 10,000)
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            // visited : 방문 기록 저장 배열
            visited = new boolean[n + 1];
            // c : 연결 요소의 개수
            int c = 0;
            // for i : 1 ~ n
            //   A 인접 리스트의 각 ArrayList 초기화
            A = new ArrayList[n + 1];
            for (int i = 1; i < n + 1; i++) {
                A[i] = new ArrayList<>();
            }
            // for i : 1 ~ m
            //   A 인접 리스트에 그래프 데이터 저장
            for (int i = 0; i < m; i++) {
                StringTokenizer graphData = new StringTokenizer(reader.readLine());
                int s = Integer.parseInt(graphData.nextToken());
                int e = Integer.parseInt(graphData.nextToken());
                A[s].add(e);
                A[e].add(s);
            }
            // for i : 1 ~ n
            //     if (방문하지 않은 노드가 있으면)
            //         c++
            //     dfs(i)
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    c++;
                    dfs(i);
                }
            }
            writer.write(String.valueOf(c));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dfs(int i) {
        // if (현재 노드 == 방문한 노드) return
        if (visited[i]) {
            return;
        }
        // visited 방문 기록 저장
        visited[i] = true;
        // 현재 연결된 노드 중 방문하지 않은 노드로 dfs 실행
        for (int j = 0; j < A[i].size(); j++) {
            int node = A[i].get(j);
            if (!visited[node]) {
                dfs(node);
            }
        }
    }
}
