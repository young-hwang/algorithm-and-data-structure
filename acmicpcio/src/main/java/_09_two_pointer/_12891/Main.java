package _09_two_pointer._12891;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static char[] dna;
    static int[] checkArr;
    static int[] myArr;
    static int status;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int S = Integer.parseInt(stringTokenizer.nextToken());
            int P = Integer.parseInt(stringTokenizer.nextToken());

            dna = new char[S];
            dna = reader.readLine().toCharArray();

            checkArr = new int[4];
            StringTokenizer checkToken = new StringTokenizer(reader.readLine());
            for (int i = 0; i < 4; i++) {
                checkArr[i] = Integer.parseInt(checkToken.nextToken());
                if (checkArr[i] == 0) status++;
            }

            myArr = new int[4];
            int result = 0;

            for (int i = 0; i < P; i++) {
                add(dna[i]);
            }

            if (status == 4) result++;

            for (int i = P; i < S; i++) {
                int j = i - P;
                remove(dna[j]);
                add(dna[i]);
                if (status == 4) result++;
            }

            writer.write(String.valueOf(result));
            writer.flush();
        } catch (Exception e) {

        }
    }

    private static void add(char value) {
        switch (value) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) status++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) status++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) status++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) status++;
                break;
        }
    }

    private static void remove(char value) {
        switch (value) {
            case 'A':
                if (myArr[0] == checkArr[0]) status--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) status--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) status--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) status--;
                myArr[3]--;
                break;
        }
    }
}
