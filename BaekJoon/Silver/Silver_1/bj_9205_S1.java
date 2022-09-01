package bj.silver;

import java.io.*;
import java.util.*;

public class bj_9205_S1 {
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int Int(String s) {
		return Integer.parseInt(s);
	}
	
	static int N;
	static Pos[] pos;
	static boolean[] isVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = Int(br.readLine());
			pos = new Pos[N + 2];
			isVisited = new boolean[N+2];
			for (int i = 0; i < N + 2; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				pos[i] = new Pos(Int(st.nextToken()),Int(st.nextToken()));
			}
			sb.append(search() ? "happy" : "sad").append('\n');
		}
		System.out.println(sb);
	}
	
	static boolean search() {
		Queue<Pos> q = new LinkedList<>();
		Pos start = pos[0];
		Pos end = pos[N+1];
		q.offer(start);
		
		while(!q.isEmpty()) {
			Pos current = q.poll();
			
			if(current.equals(end)) return true;
			
			for(int i=1; i<N+2; ++i) {
				if(!isVisited[i] && 
						(Math.abs(current.x - pos[i].x)+Math.abs(current.y - pos[i].y))<=1000) {
					q.offer(pos[i]);
					isVisited[i]=true;
				}
			}
		}
		return false;
	}
}
