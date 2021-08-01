package bronze;

import java.io.*;
import java.util.*;

public class bj_13866_B4 {

	static int[] level = new int[4];
	static boolean[] isVisited=new boolean[4];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		for(int i=0;i<4;++i) level[i] = Integer.parseInt(st.nextToken());
		comb(0);
		System.out.println(min);
	}

	static void comb(int cnt) {
		if(cnt == 2) {
			int sumA = 0, sumB=0;
			for(int i=0;i<4;++i) {
				if(isVisited[i]) sumA += level[i];
				else sumB += level[i];
			}
			min = Math.min(min, Math.abs(sumA-sumB));
			return;
		}
		
		for(int i=0;i<4;++i) {
			if(isVisited[i]) continue;
			isVisited[i] = true;
			comb(cnt+1);
			isVisited[i] = false;
		}
	}
}
