package gold;

import java.io.*;
import java.util.*;

// 깔때 내오른쪽에 이미 깔려있으면 안됌(무한로프)
// 11%에서 틀렸었는데 이게 다리를깔때 다리개수가 0이 아닐때도 추가로 0개깔면 답이되는 경우가 있었음!
public class bj_15685_G4 {
	
	static int N, M, H,map[][],ans = Integer.MAX_VALUE,input[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		if (M == 0) { // 가로선이 없으면 그냥 그상태가 답.
			System.out.println("0");
		} else {
			map = new int[H][N];
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				map[x][y] = 1; //우측으로간다
				map[x][y+1] = -1; // 좌측으로간다.
			}
			process();
			System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		}
	}

	static void process() { // 여기서 과정을 처리하고 값을 반환해준다.
		for (int i = 0; i < 4; ++i) { // 다리를 0개,1개,2개,3개까지만 깔아본다.(조건)
			input = new int[i];
			combi(0, 0, i);
		}
	}

	static void combi(int start, int cnt, int R) {
		
		if (ans != Integer.MAX_VALUE) return; // ans에 값이 들어가면 그게 답임(증가하면서 다리까는개수늘려서)
		if (cnt == R) {
			// 1. 실제로 깐다(가짜 맵에)
			for (int i = 0; i < R; ++i) {
				int val = input[i];
				int x = val / N;
				int y = val % N;
				map[x][y] = 1;
				map[x][y+1]=-1;
			}
			// 2. n1번 이 n1로 나가지는 지 확인한다.
			if (isSuccess()) {
				ans = Math.min(ans, R); // 갱신한다.
				return;
			}
			// 3. 맵을 원상복구 시킨다.
			for (int i = 0; i < R; ++i) {
				int val = input[i];
				int x = val / N;
				int y = val % N;
				map[x][y] = map[x][y+1] = 0;
			}
			return;
		}

		for (int i = start; i < H * N; i++) {// 다리길이가 2
			if (i % N == N - 1) continue; // 가장 마지막 열은 다리를 깔 수 없음
			if (map[i / N][i % N]!=0 || map[i/N][(i%N)+1] !=0) continue; // 이미 다리가 깔려있으면 통과
			input[cnt] = i;
			combi(i + 1, cnt + 1, R);
		}
	}

	private static boolean isSuccess() {
		for (int i = 0; i < N; ++i) {
			int x = 0; // 시작은 다 0번 행
			int y = i;// i번째 다리
			while (x < H) {//마지막행까지내려간다.
				if(map[x][y]!=0) { // 다리가 있으면
					y+=map[x][y];//이동시켜준다.
				}
				x++;
			}
			if (y != i) return false; // 다르게 나가졌으면 false로
		}
		return true;
	}

}
