package bronze;

import java.io.*;
import java.util.*;

public class bj_2309_B2 {

	static int[] hobit = new int[9];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;++i) {
			hobit[i] = Integer.parseInt(br.readLine());
		}
		comb(0,0);
	}
	
	static int[] input = new int[7];
	static boolean[] isVisited = new boolean[9];
	public static void comb(int cnt, int sum) {
		if(cnt == 7) {
			if(sum == 100) {
				Arrays.sort(input);
				PriorityQueue<Integer> answer = new PriorityQueue<Integer>();
				for(int i=0;i<7;++i) answer.add(hobit[input[i]]);
				while(!answer.isEmpty()) System.out.println(answer.poll());
				System.exit(0);
			}	
			return;
		}
		
		for(int i=0;i<9;++i) {
			if(isVisited[i])continue;
			isVisited[i] = true;
			input[cnt]=i;
			comb(cnt+1, sum+hobit[i]);
			isVisited[i] = false;
		}
	}

}
