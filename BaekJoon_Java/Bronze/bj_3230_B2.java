package bronze;

import java.io.*;
import java.util.*;

public class bj_3230_B2 {

	static class Player implements Comparable<Player> {
		int val, idx;

		Player(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}

		@Override
		public int compareTo(Player o) {
			return Integer.compare(this.val, o.val);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Player[] first = new Player[N];
		for(int i=0;i<N;++i) first[i] = new Player(-1,-1);
		
		for (int i = 0; i < N; ++i) {
			int val = Integer.parseInt(br.readLine());
			for (int j = 0; j < N; ++j) {
				if (i == j) continue;
				if(first[j].idx == -1) continue;
				if (first[j].val >= val) {
					first[j].val++;
				}
			}
			first[i].idx = i+1;
			first[i].val = val;
		}
		Arrays.sort(first);
		Player[] second = new Player[M];
		for(int i=0;i<M;++i) {
			second[i] = new Player(first[i].idx, -1);
		}
		for(int i=M-1;i>=0;--i) {
			int val = Integer.parseInt(br.readLine());
			for (int j = M-1; j >=0; --j) {
				if (i == j) continue;
				
				if (second[j].val >= val) {
					second[j].val++;
				}
			}
			
			second[i].val = val;
		}
		Arrays.sort(second);
		for(int i=0;i<3;++i)  System.out.println(second[i].idx);
	}

}
