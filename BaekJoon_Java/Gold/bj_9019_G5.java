import java.io.*;
import java.util.*;

public class bj_9019_G5 {
	static class Check{
		public boolean isVisited;
		public int parent;
		public char register;
		
		public Check() {
			isVisited = false;
			parent = 0;
			register=' ';
		}
		
		public void set(boolean isVisited, int parent, char register) {
			this.isVisited = isVisited;
			this.parent = parent;
			this.register = register;
		}
	}
	static int A, B;
	static final int max = 10000;
	static Check[] checks;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			checks = new Check[max];
			for(int i=0;i<max;++i) checks[i] = new Check();

			Queue<Integer> q = new LinkedList<>();
			q.add(A);
			checks[A].isVisited = true;

			while (true) {
				int current = q.poll();

				int LtoR = current / 1000; // 맨 오른쪽으로 갈애
				int RtoL = current % 10; // 맨 왼쪽으로 갈애

				int D = (2 * current) % max;
				int S = current == 0 ? max - 1 : current - 1;
				int L = (current * 10 + LtoR) % max;
				int R = 1000 * RtoL + current / 10;
				
				if(!checks[D].isVisited) {
					checks[D].set(true, current, 'D');
					q.add(D);
				}
				if(!checks[S].isVisited) {
					checks[S].set(true, current, 'S');
					q.add(S);
				}
				if(!checks[L].isVisited) {
					checks[L].set(true, current, 'L');
					q.add(L);
				}
				if(!checks[R].isVisited) {
					checks[R].set(true, current, 'R');
					q.add(R);
				}
				// 찾았으면?
				if(checks[B].isVisited) {
					int tmp = B;
					while(tmp != A) {
						int pr = checks[tmp].parent;
						sb.append(checks[tmp].register);
						tmp = pr;
					}
					System.out.println(sb.reverse());
					break;
				}
			}
		}
	}

}
