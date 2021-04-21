package CodeUp91to100;

import java.io.*;
import java.util.*;

public class Main_Q_96 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] pos = new int[19][19];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			pos[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=1;
		}
		for(int i=0;i<19;++i) {
			for(int j=0;j<19;++j) {
				System.out.print(pos[i][j]+" ");
			}
			System.out.println();
		}
	}
}
