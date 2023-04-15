package _01_arithmetic._14681;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

		try {
			int x = Integer.parseInt(br.readLine());
			int y = Integer.parseInt(br.readLine());
            int quadrant = main.getQuadrant(x, y);
            bw.write(String.valueOf(quadrant));
            bw.flush();
		} catch (Exception e) {
		}
    }

    public int getQuadrant(int x, int y) {
        int bX  = x >= 0 ? 1: 0;
        int bY = y >= 0 ? 2: 0;
        int quadrant = bX + bY;
        if (quadrant == 0) {
            return 3;
        } else if (quadrant == 1) {
            return 4;
        } else if (quadrant == 2) {
            return 2;
        } else {
            return 1;
        }
    }
}
