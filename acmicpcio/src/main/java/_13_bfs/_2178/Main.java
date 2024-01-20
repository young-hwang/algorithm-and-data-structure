package _13_bfs._2178;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우
    static int[][] A;
    static boolean[][] visited;
    static int n;
    static int m;

    public static void main(String[] args) {
        /*
        dx, dy 상하좌우를 탐색하기 위한 정의 변수
        A 데이터 저장 2차원 배열
        n row, m column
        visited 방문 여부를 저장하는 2차원 배열
        for i in 0..n
            for j in 0..m
                A 초기화
        bfs(0, 0) 실행하기

        bfs {
            큐 시작노드 삽입
            visited 현재 노드 방문 처리
            while(큐가 비어있을 때까지)
                큐에서 노드 데이터 가져오기
                for 상하좌우 탐색
                    if(유효한 노드)
                        if (방문하지 않은 노드)
                            visited 노드 방문 처리
                            방문 노드 = 노드 데이터 + 1
                            큐에 노드 추가

        }
         */
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(stringTokenizer.nextToken());
            m = Integer.parseInt(stringTokenizer.nextToken());
            A = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                char[] row = reader.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    A[i][j] = Integer.parseInt(String.valueOf(row[j]));
                    visited[i][j] = false;
                }
            }
            bfs(0, 0);
            writer.write(String.valueOf(A[n - 1][m - 1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new int[]{y, x});
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int i = 0; i < 4; i++) {
                y = node[0] + dy[i];
                x = node[1] + dx[i];
                if (y >= 0 && y < n && x >= 0 && x < m && A[y][x] == 1) {
                    if (!visited[y][x]) {
                        visited[y][x] = true;
                        A[y][x] = A[node[0]][node[1]] + 1;
                        queue.add(new int[]{y, x});
                    }
                }
            }
        }
    }
}
