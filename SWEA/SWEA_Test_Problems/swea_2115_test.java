package test;

import java.io.*;
import java.util.*;

public class swea_2115_test {

	static int N,M,C,map[][],input[],max, revsumA, revsumB;
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/swea_2115_test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		for(int tc=1;tc<=T;++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = stoi(st.nextToken());//벌통크기
			M = stoi(st.nextToken());//벌통개수
			C = stoi(st.nextToken());//꿀채취최대양
			map = new int[N][N];//벌통맵
			input = new int[2];
			max = Integer.MIN_VALUE; // 최대 벌꿀
			for(int i=0;i<N;++i) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;++j) map[i][j] = stoi(st.nextToken());
			}
			//탐색을 시작한다.
			searchHoney(0,0);
			sb.append("#").append(tc).append(" ").append(max).append('\n');
		}
		System.out.println(sb);
	}
	static void searchHoney(int start, int cnt) {
		if(cnt == 2) { // 개수 만큼 다 골랐다면 ?(일꾼이 두명임)
			// 겹치면 리턴해준다.input[1]이 input[0]~input[0]+M-1과 겹치면 안된다.
			if(input[0]<input[1] && input[1]<input[0]+M) return;
			// 행이 다르면 가로로 연속된게 아니므로 리턴해준다.(시작과끝이 다른행이면)
			if(input[0]/N != (input[0]+(M-1))/N) return; // 벌통 A
			if(input[1]/N != (input[1]+(M-1))/N) return; // 벌통 B
			// 뽑힌 벌통으로 최대 양인지 살펴보고 갱신해준다.
			max = Math.max(max, getRevenu(input[0], input[1]));
			return;
		}
		for(int i=start;i<N*N;++i) { // 0-15까지의 배열인덱스를 2만큼 뽑는다.
			input[cnt] = i;
			searchHoney(i+1,cnt+1);
		}
	}
	
	// 이익계산해서 반환해준다.
	private static int getRevenu(int honeyA, int honeyB) {
		revsumA = 0;
		for(int i=1;i<=M;++i) {
			check(0,honeyA,honeyA+M,i,0,0,0); // 1개..2개...3개..m개 뽑기
		}
		revsumB = 0;
		for(int i=1;i<=M;++i) {
			check(1,honeyB,honeyB+M,i,0,0,0);
		}
		int revenu = revsumA + revsumB;//전체 수익을 더해주고
		return revenu; // 반환해준다.
	}
	static void check(int type, int start, int n, int R, int cnt, int sum, int rev) {
		if(cnt == R) { // 1개...2..R개 뽑아서 만들수 있는 최대이익을 만들어낸다.
			if(sum <= C) { // 수용량 범위 안이면  이익을 갱신한다.
				if(type == 0) revsumA= Math.max(revsumA, rev);
				else revsumB = Math.max(revsumB, rev);
			}
			return;
		}
		for(int i=start; i<n;++i) {
			int val = map[i/N][i%N];
			check(type,i+1, n, R,cnt+1, sum + val, rev + (int)Math.pow(val, 2));
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}