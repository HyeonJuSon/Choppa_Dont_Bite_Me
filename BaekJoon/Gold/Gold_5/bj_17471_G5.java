package bj.gold;

import java.io.*;
import java.util.*;

public class bj_17471_G5 {

	static int N, R, areas[], adjList[][], sum, min = Integer.MAX_VALUE, partSum;
	static boolean isVisited[], check[];

	public static void main(String[] args) throws Exception {
//		combi(0,1);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// 구역의 개수
		areas = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; ++i)
			areas[i] = Integer.parseInt(st.nextToken());
		adjList = new int[N + 1][N + 1]; // 인접행렬
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int C = Integer.parseInt(st.nextToken());
			for (int cnt = 0; cnt < C; ++cnt) {
				adjList[i][Integer.parseInt(st.nextToken())] = 1;
			}
		}
		for (int i = 0; i <= N / 2; ++i) {
			isVisited = new boolean[N + 1];
			R = i; // 1개, 2개, 3개, ,,, , N/2개를 뽑아본다.
			makeGroup(0, 1);
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void makeGroup(int cnt, int start) {
		if (cnt == R) {
			sum = Integer.MAX_VALUE;
			// 연결여부검사
			Linked();
			// 차이 값 갱신
			min = Math.min(min, sum);
			return;
		}
		for (int i = start; i <= N; ++i) {
			isVisited[i] = true;
			makeGroup(cnt + 1, i + 1);
			isVisited[i] = false;
		}
	}

	static void Linked() {
		int selSum = 0, unselSum = 0;
		int[] parents = new int[N + 1];
		check = new boolean[N + 1];
		// 뽑힌 여부 검사 후 담기.
		for (int i = 1; i <= N; ++i) {
			if (isVisited[i]) parents[i] = 1; // 뽑힌 구역의 값을 넣어준다.
			else parents[i] = 0; // 안뽑힌 구역의 값을 넣어준다.
		}
		// 1. 뽑힌애들끼리 연결되어 있는지?
		for (int i = 1; i <= N; ++i) {
			if (parents[i] == 1 && !check[i]) { // 뽑힌 구역이고, 체크전이면
				partSum = 0; // 연결된것들의 합을 구한다.
				search(i, parents);
				selSum = partSum;
				break;
			}
		}
		// 2. 안뽑힌애들끼리 연결되어 있는지?
		for (int i = 1; i <= N; ++i) {
			if (parents[i] == 0 && !check[i]) { // 뽑힌 구역이고, 체크전이면
				partSum = 0; // 연결된것들의 합을 구한다.
				search(i, parents);
				unselSum = partSum;
				break;
			}
		}
		// 3. 방문안된 애 없는지 확인(하나라도 있다면 연결이 안된 것.)
		for (int i = 1; i <= N; ++i) {
			if (!check[i]) return;
		}
		// 4. 차이를 계산해준다.
		sum = Math.abs(selSum - unselSum);
	}

	public static void search(int x, int[] parents) {
		check[x] = true;
		partSum += areas[x];
		for (int i = 1; i < N + 1; i++) {
			if (!check[i] && parents[i] == parents[x] && adjList[i][x] == 1) {
				search(i, parents);
			}
		}
	}
}
