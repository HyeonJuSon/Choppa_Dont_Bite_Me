package com.algo.d2;
import java.util.*;
import java.io.*;
public class swea_2001_d2 {

	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/Input_d2_2001.txt"));
		Scanner sc = new Scanner(System.in);
		int T= Integer.parseInt(sc.nextLine());
		for(int tc=1;tc<=T; ++tc) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] flies=new int[N][N];
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					flies[i][j] = sc.nextInt();
				}
			}
			int max = -1;
			int sx =0,sy=0;
			while(true) {
				int sum =0;
				for(int i=sx; i<sx+M;++i) {
					for(int j=sy;j<sy+M;++j) {
						sum+= flies[i][j];
					}
				}
				max = Math.max(max, sum);
				sy++;
				if(sy +M > N) {
					sy = 0;
					sx++;
				}
				if(sx+M > N) break;
			}
			System.out.println("#"+tc+" "+max);
		}
		sc.close();
	}

}
