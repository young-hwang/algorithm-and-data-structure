package _15_greedy._11047;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
N: 동전의 종료
K: 동전의 합
A: 동전의 종류 오름 차순
R: 동전의 수
for i = N-1 to 0
    R += K / A[i]
    K %= A[i]

O(N)
 */
public class Main {
    public static void main(String[] args) {
        int N;
        int K;
        int[] A;
        int R = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(token.nextToken());
            K = Integer.parseInt(token.nextToken());
            A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(reader.readLine());
            }

            for (int i = N-1; i >= 0 ; i--) {
                R += K / A[i];
                K %= A[i];
            }
            writer.write(String.valueOf(R));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
