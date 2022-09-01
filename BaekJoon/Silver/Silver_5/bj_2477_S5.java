package bj;

import java.util.*;
import java.io.*;

public class bj_2477_S5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());			// 참외 개수를 입력받는다.
		int[] length = new int[6];							// 6각형이므로 변의 길이는 6개		
		for (int i = 0; i < length.length; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			length[i] = Integer.parseInt(st.nextToken());	// 길이를 입력받는다.
		}

		int bigGaro = 0, bigSero = 0;						// 가장 긴 가로길이, 긴 세로길이(정확히가로세로는모름)
		for (int i = 0; i < 6; ++i) {						// 순서대로 저장, 짝/홀로 같은방향이 나눠져있음
			if (i % 2 == 0) bigGaro = Math.max(bigGaro, length[i]);
			else bigSero = Math.max(bigSero, length[i]);	// 사실 세로인지 가로인지는 알수없음.그냥 같은방향인 것만 암
		}
		
		int smallGaro = 0, smallSero = 0;					// 특정한 한 변의 앞 뒤 길이의 합이 다른 변의 최대 길이와 같으면 파인곳임.
		for (int i = 0; i < 6; ++i) {						// 예를들어 60의 앞 뒤는 30,20 이고 합은 50 -> 다른변과 같음 = 파인곳
			if(i % 2 == 0) { 								// bigSero 길이가 앞 뒤 합이랑 같다면? 작은 가로가 됌
				if(bigSero == (length[(i+1)%6] + length[(i+5)%6])) smallGaro = length[i];
			}else { 										// bigGaro 길이가 앞 뒤 합이랑 같다면? 작은 세로가 됌
				if(bigGaro == (length[(i+1)%6] + length[(i+5)%6])) smallSero = length[i];
			}
		}
		int big = bigSero * bigGaro;						// 큰 사각형의 넓이
		int small = smallSero * smallGaro;					// 작은 사각형의 넓이 -> 큰 - 작은 사각형 = 구하려는 사각형
		int res = (big - small) * K; 						// 구하려는 사각형 * 참외 개수
		System.out.println(res);
	}

}
