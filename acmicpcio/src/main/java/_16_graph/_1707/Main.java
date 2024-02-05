package _16_graph._1707;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    /*
     N: 그래프 개수
     V: 정점의 개수
     E: 간선의 개수
     A: 그래프 저장 인접 리스트
     check: 이분 그래프 확인 배열
     visited: 방문 기록 저장
     for i = 1 to N {
        V 노드 개수
        E 간선 개수
        for i = 1 to V {
            A 인접 리스트의 ArrayList로 초기화
        }
        for i = 1 to E {
            A 인접 리스트에 간선 정보 저장
        }
        for i = 1 to V {
            각 노드에서 DFS 실행 -> 결과가 이분 그래프가 아니면 종료
        }
      }

      DFS {
        현재 노드 출력
        visited 배열에 현재 노드 방문기록 저장
        if (현재 연결 노드 중 방문하지 않은 노드) {
            DFS 실행 하기
        } else {
            이미 방문한 노드이나 현재 노드와 같은 그룹이면 이분 그래프가 아님
        }
      }
    */
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;

    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(reader.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer token = new StringTokenizer(reader.readLine());
                int V = Integer.parseInt(token.nextToken());
                int E = Integer.parseInt(token.nextToken());
                A = new ArrayList[V + 1];
                visited = new boolean[V + 1];
                check = new int[V + 1];
                isEven = true;
                for (int j = 1; j <= V; j++) {
                    A[j] = new ArrayList<>();
                }
                for (int j = 0; j < E; j++) {
                    StringTokenizer tokenE = new StringTokenizer(reader.readLine());
                    int start = Integer.parseInt(tokenE.nextToken());
                    int end = Integer.parseInt(tokenE.nextToken());
                    A[start].add(end);
                    A[end].add(start);
                }
                for (int j = 1; j <= V; j++) {
                    if (isEven) {
                        DFS(j);
                    } else {
                        break;
                    }
                }

                if (isEven) {
                    writer.write("YES\n");
                } else {
                    writer.write("NO\n");
                }
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void DFS(int node) {
        visited[node] = true;
        for (int j : A[node]) {
            if (!visited[j]) {
                check[j] = (check[node] + 1) % 2;
                DFS(j);
            } else {
                if (check[j] == check[node]) {
                    isEven = false;
                    return;
                }
            }
        }
    }
}
