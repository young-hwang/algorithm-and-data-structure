package _17_union_find._1717;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < m; i++) {
                StringTokenizer methodToken = new StringTokenizer(reader.readLine());
                int operation = Integer.parseInt(methodToken.nextToken());
                int a = Integer.parseInt(methodToken.nextToken());
                int b = Integer.parseInt(methodToken.nextToken());
                if (operation == 0) {
                    union(a, b);
                } else {
                    writer.write(sameSet(a, b) ? "YES\n" : "NO\n");
                }
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean sameSet(int a, int b) {
        if (find(a) == find(b)) {
            return true;
        } else {
            return false;
        }
    }

    private static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
