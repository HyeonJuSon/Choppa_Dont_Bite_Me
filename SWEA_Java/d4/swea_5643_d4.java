package d4;

import java.io.*;
import java.util.*;

public class swea_5643_d4 {
	static ArrayList<ArrayList<Integer>> ctop = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> ptoc = new ArrayList<>();
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T;++tc) {
			N = Integer.parseInt(br.readLine()); // 학생수
			ctop.clear();
			ptoc.clear();
			for(int i=0;i<N+1;++i) {
				ctop.add(new ArrayList<>());
				ptoc.add(new ArrayList<>());
			}
			int M = Integer.parseInt(br.readLine()); // 비교횟수
			for(int i=0;i<M;++i) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int small = Integer.parseInt(st.nextToken());
				int big = Integer.parseInt(st.nextToken());
				ctop.get(small).add(big); // 자식에서 부모로
				ptoc.get(big).add(small); // 부모에서 자식으로
			}
			int result = 0;
			for(int i=1;i<=N;++i) {
				result = (count(i) == N-1) ? result + 1 : result;
			}
			sb.append("#").append(tc).append(" ").append(result).append('\n');
		}
		System.out.println(sb);
	}
	
	static int count(int idx) {
		Queue<Integer> q = new LinkedList<>();
		boolean isVisited[]=new boolean[N+1];
		// 자식에서 부모로 나감
		q.offer(idx);
		int cnt = 0;
		while(!q.isEmpty()) {
			int current = q.poll();
			for(int i=0;i<ctop.get(current).size();++i) {
				int val = ctop.get(current).get(i);
				if(!isVisited[val]) {
					isVisited[val] = true;
					q.offer(val);
					cnt++;
				}
			}
		}
		// 부모에서 자식으로 
		q.offer(idx);
		while(!q.isEmpty()) {
			int current = q.poll();
			for(int i=0;i<ptoc.get(current).size();++i) {
				int val = ptoc.get(current).get(i);
				if(!isVisited[val]) {
					isVisited[val] = true;
					q.offer(val);
					cnt++;
				}
			}
		}
		return cnt;
	}
}
