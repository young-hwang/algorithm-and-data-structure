package _14_binary_search._1920;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        /*
        N: A 배열의 크기
        A : N개의 정수 배열
        M: 찾을 정수의 개수
        Q: 찾을 정수의 배열
        N 입력 받기
        A에 N배열 생성
        for i in 0..N
           A[i] 입력 받기
        M 입력 받기
        Q에 M배열 생성
        Arrays.sort(A)
        for i in 0..M
           Q[i] 입력 받기
        for i in 0..M
             while(left <= right)
                mid = (left + right) / 2
                if (A[mid] == Q[i])
                    writer.write("1\n")
                    break
                else if (A[mid] > Q[i])
                    right = mid - 1
                else
                    left = mid + 1
         */
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(reader.readLine());
            int[] A = new int[N];
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            int M = Integer.parseInt(reader.readLine());
            int[] Q = new int[M];
            StringTokenizer qToken = new StringTokenizer(reader.readLine());
            for (int i = 0; i < M; i++) {
                Q[i] = Integer.parseInt(qToken.nextToken());
            }
            Arrays.sort(A);
            for (int i = 0; i < M; i++) {
                int left = 0;
                int right = N - 1;
                boolean find = false;
                while( left <= right) {
                    int mid = (left + right) / 2;
                    if (A[mid] == Q[i]) {
                        find = true;
                        break;
                    } else if (A[mid] > Q[i]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                if (find) {
                    writer.write("1\n");
                } else {
                    writer.write("0\n");
                }
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}