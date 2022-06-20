package bronze;

import java.io.*;
import java.util.*;

public class bj_13420_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			long A = Long.parseLong(st.nextToken());
			String operator = st.nextToken();
			long B = Long.parseLong(st.nextToken());
			String and = st.nextToken();
			long inputAnswer = Long.parseLong(st.nextToken());
			long answer = 0;
			switch (operator) {
			case "+":
				answer = A + B;
				break;
			case "-":
				answer = A - B;
				break;
			case "/":
				answer = A / B;
				break;
			case "*":
				answer = A * B;
				break;
			}
			if(!and.equals("=")) System.out.println("wrong answer");
			else
				System.out.println(inputAnswer == answer ? "correct" : "wrong answer");
		}
	}

}
