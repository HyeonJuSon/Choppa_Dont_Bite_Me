package bronze;

import java.util.Arrays;
import java.util.Scanner;

public class bj_2966_B2 {
	static class Rank implements Comparable<Rank>{
		int cnt;
		String id;

		Rank(int cnt, String id) {
			this.cnt = cnt;
			this.id = id;
		}

		@Override
		public int compareTo(Rank o) {
			return Integer.compare(o.cnt, this.cnt);
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = "ABC";
		String c = "BABC";
		String h = "CCAABB";
		int N = sc.nextInt();
		String target = sc.next();
		Rank[] ansCnt = new Rank[3];
		ansCnt[0] = new Rank(0, "Adrian");
		ansCnt[1] = new Rank(0, "Bruno");
		ansCnt[2] = new Rank(0, "Goran");
		int max = 0;
		for (int i = 0; i < N; ++i) {
			char nowVal = target.charAt(i);
			if (s.charAt(i % s.length()) == nowVal) ansCnt[0].cnt++;
			if (c.charAt(i % c.length()) == nowVal)	 ansCnt[1].cnt++;
			if (h.charAt(i % h.length()) == nowVal)	 ansCnt[2].cnt++;
			max=Math.max(max, Math.max(ansCnt[0].cnt, 
					Math.max(ansCnt[1].cnt,ansCnt[2].cnt)));
		}
		System.out.println(max);
		for(int i=0;i<3;++i) {
			if(max == ansCnt[i].cnt) System.out.println(ansCnt[i].id);
		}
	}

}
