package _01_arithmetic._1110;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		/*
		 * 0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다. 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다. 그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.
		 * 26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.
		 * 위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.
		 * N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.
		 * 첫째 줄에 N이 주어진다. N은 0보다 크거나 같고, 99보다 작거나 같은 정수이다.
		 * 첫째 줄에 N의 사이클 길이를 출력한다.
		 *
		 * 26
		 *
		 * 4
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String N = "";
		String result = "";
		String rtn = "";
		int cycle = 0;

		N = br.readLine();

		while (!N.equals(rtn)) {
			if (cycle == 0) rtn = N;

			if (rtn.length() <= 1) rtn = "0" + rtn;

			result = String.valueOf((Integer.parseInt(rtn.substring(0, 1)) + Integer.parseInt(rtn.substring(1, 2))));

			if (rtn.substring(1, 2).equals("0"))
				rtn = result.substring(result.length() -1, result.length());
			else
				rtn = rtn.substring(1, 2) + result.substring(result.length() -1, result.length());

			cycle++;
		}

		bw.write(String.valueOf(cycle));
		bw.flush();
	}

}
