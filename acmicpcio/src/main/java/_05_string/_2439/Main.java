package _05_string._2439;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
		 * 하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
		 * 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
		 * 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
		 *
		 * 5
		 *
		 *     *
		 *    **
		 *   ***
		 *  ****
		 * *****
		 */

		Scanner sc = new Scanner(System.in);
		int value = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < value; i++) {
			for (int j = 0; j < value; j++) {
				if (value - 1 - i > j ) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

}
