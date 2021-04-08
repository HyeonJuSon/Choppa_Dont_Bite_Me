import java.io.*;
import java.util.*;

public class bj_9019_G5 {
	static class Register{
		public boolean isVisited = false;
		public int parent = 0;
		public char register =' ';
		public Register() { }
		public void set(boolean isVisited, int parent, char register) {
			this.isVisited = isVisited;
			this.parent = parent;
			this.register = register;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int max = 10000;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			Register[] registers = new Register[max];
			for(int i=0;i<max;++i) registers[i] = new Register();
			Queue<Integer> q = new LinkedList<>();
			q.add(A);
			registers[A].isVisited = true;
			while (true) {
				int current = q.poll();
				int D = (2 * current) % max;
				int S = current == 0 ? max - 1 : current - 1;
				int L = (current * 10 + (current / 1000)) % max;
				int R = 1000 * (current % 10) + current / 10;
				
				if(!registers[D].isVisited) {
					registers[D].set(true, current, 'D');
					q.add(D);
				}
				if(!registers[S].isVisited) {
					registers[S].set(true, current, 'S');
					q.add(S);
				}
				if(!registers[L].isVisited) {
					registers[L].set(true, current, 'L');
					q.add(L);
				}
				if(!registers[R].isVisited) {
					registers[R].set(true, current, 'R');
					q.add(R);
				}
				// 찾았으면?
				if(registers[B].isVisited) {
					int tmp = B;
					while(tmp != A) {
						sb.append(registers[tmp].register);
						tmp = registers[tmp].parent;
					}
					bw.write(sb.reverse().append('\n').toString());
					break;
				}
			}
		}
		bw.close();
	}
}
