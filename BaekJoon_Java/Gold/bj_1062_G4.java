import java.io.*;
import java.util.*;

public class bj_1062_G4 {

	static int N, K, Max = Integer.MIN_VALUE;
	static String input[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		input = new String[N]; // 단어들을 입력받을 배열
		if (K < 5) { // 최소 a n t i c 은 읽어야 함.
			System.out.println(0);
		} else if (K == 26) { // 알파벳 전체 가능하면 다 읽을 수 있음.
			System.out.println(N);
		} else {
			for (int i = 0; i < N; ++i) {
				String str = br.readLine();
				input[i] = str.substring(4, str.length() - 4);
			}
			int bitMask = 0;
			bitMask |= 1 << ('a' - 97); // 비트마스킹 처리를 해준다.
			bitMask |= 1 << ('n' - 97);
			bitMask |= 1 << ('t' - 97);
			bitMask |= 1 << ('i' - 97);
			bitMask |= 1 << ('c' - 97);
			comb(0, 0, bitMask);
			System.out.println(Max);
		}
	}

	static void comb(int cnt,int start, int bitMask) {
		if (cnt == K - 5) {
			int readCnt = 0;
			for (int i = 0; i < N; ++i) { // 입력받은 단어 전체를 검사해본다.
				boolean isReadable = true;
				for (int j = 0; j < input[i].length(); ++j) {
					if ((bitMask & ( 1 << (input[i].charAt(j) - 97)) ) == 0) { // 읽을 수 없는 단어가 포함되어 있으면
						isReadable = false;
						break;
					}
				}
				// 읽을 수 있으면 카운팅
				if (isReadable)	++readCnt;
			}
			Max = Math.max(Max, readCnt); // 갱신해준다.
			return;
		}
		for (int i = start; i < 26; ++i) {
			if ((bitMask & 1 << i) != 0) continue; // 이미 방문된 곳은 패스
			comb(cnt + 1, i+1, bitMask | 1 << i);// 마킹처리하면서 넘겨준다.
		}
	}
}