package com.sweaTestQuestion;

import java.util.*;
import java.io.*;

public class swea_1238_D4 {
	public static class Node{
		int depth;
		int vertex;
		Node(int depth, int vertex){
			this.depth = depth;
			this.vertex = vertex;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(tk.nextToken());
			int startIdx = Integer.parseInt(tk.nextToken());
			int[][] a = new int[N+1][N+1];
			int[] visit = new int[N+1];
			Queue <Node> q = new LinkedList<>();
			ArrayList <Node> result = new ArrayList<>();
			int max_depth = 1;
			
			tk = new StringTokenizer(br.readLine());
			while(tk.hasMoreTokens()) {
				int from = Integer.parseInt(tk.nextToken());
				int to = Integer.parseInt(tk.nextToken());
				a[from][to] = 1;
			}
			
			
			q.add(new Node(1, startIdx));
			result.add(new Node(1, startIdx));
			visit[startIdx] = 1;
			
			
			while(!q.isEmpty()) {
				Node node = q.poll();
				int vertex = node.vertex;
				int depth = node.depth;
				for(int i = 0; i < N; i++) {
					if(a[vertex][i] == 1 && visit[i] == 0) {
						visit[i] = 1;
						result.add(new Node(depth + 1, i));
						q.add(new Node(depth+1, i));
					}
				}
				max_depth = Math.max(max_depth, depth);
			}
			
			int max = 1;
			for(int i = 0; i < result.size(); i++) {
				if(result.get(i).depth == max_depth) {
					max = Math.max(max, result.get(i).vertex);
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}