package bronze;

import java.io.*;
import java.util.*;

public class bj_5575_B4 {

	static class work {
		int sh, sm, ss;
		int eh, em, es;

		work(int sh, int sm, int ss, int eh, int em, int es) {
			this.sh = sh;
			this.sm = sm;
			this.ss = ss;
			this.eh = eh;
			this.em = em;
			this.es = es;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		work[] workers = new work[3];
		for (int i = 0; i < 3; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sh = Integer.parseInt(st.nextToken());
			int sm = Integer.parseInt(st.nextToken());
			int ss = Integer.parseInt(st.nextToken());
			int eh = Integer.parseInt(st.nextToken());
			int em = Integer.parseInt(st.nextToken());
			int es = Integer.parseInt(st.nextToken());
			workers[i] = new work(sh, sm, ss, eh, em, es);
		}

		for (int i = 0; i < 3; ++i) {
			int h, m, s;
			if (workers[i].ss > workers[i].es) {
				--workers[i].em;
				workers[i].es += 60;
			}
			s = workers[i].es - workers[i].ss;
			if (workers[i].sm > workers[i].em) {
				--workers[i].eh;
				workers[i].em += 60;
			}
			m = workers[i].em - workers[i].sm;
			h = workers[i].eh - workers[i].sh;
			System.out.println(h+" "+m+" "+s);
		}
	}

}
