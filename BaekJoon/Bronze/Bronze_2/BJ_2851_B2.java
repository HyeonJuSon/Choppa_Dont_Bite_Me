import java.io.*;
import java.util.*;

public class BJ_2851_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int[] score = new int[10];
		for (int i = 0; i < 10; ++i) {
			sum += Integer.parseInt(br.readLine());
			score[i] = sum;
		}

		int answer = 0;
		int i = 0;
		for (i = 0; i < 10; ++i) {
			if (score[i] <= 100) {
				answer = score[i];
			}else break;
		}
		if (i < 10 && 100 - answer >= score[i] - 100)
			System.out.println(score[i]);
		else
			System.out.println(answer);
	}

}
