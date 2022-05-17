package gold;

import java.io.*;
import java.util.*;

public class BJ_16638_G1 {

	static int N, number[];
	static char oper[];
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE; // 정답 값
		number = new int[N]; // 숫자 담는 용
		oper = new char[N]; // 연산자 담는 용
		String input = br.readLine();
		// 01. 데이터 전처리
		for (int i = 0; i < input.length(); ++i) {
			char now = input.charAt(i);
			if ('0' <= now && now <= '9')
				number[i] = now - '0';
			else
				oper[i] = now;
		}
		// 02. 탐색
		// 최대 뽑을 수 있는 괄호를 뽑아낸다. 연산자 수가 짝수면 N / 4 개 홀수면 N/4+1
		int target = (N / 2) % 2 == 0 ? N / 4 : N / 4 + 1;
		// R == 0개일 때 계산
		calculate(new int[1]);
		// 그 외의 계산
		for (int R = 1; R <= target; ++R) {
			find(0, 1, R, new int[R]);
		}
		// 출력
		System.out.println(max);
	}

	static void calculate(int[] select) {
		// 연산자 방문 처리
		boolean[] isVisited = new boolean[N];
		int[] tmpNumber = new int[N];
		for (int i = 0; i < N; ++i)
			tmpNumber[i] = number[i];
		// 1. 괄호부터 계산한다.
		for (int i = 0; i < select.length; ++i) {
			if (select[i] != 0) {
				int selectedIdx = select[i]; // 뽑은 인덱스를 추출
				int front = selectedIdx - 1;
				int back = selectedIdx + 1;
				switch (oper[selectedIdx]) {
				case '+':
					tmpNumber[front] += tmpNumber[back];
					break;
				case '-':
					tmpNumber[front] -= tmpNumber[back];
					break;
				case '*':
					tmpNumber[front] *= tmpNumber[back];
					break;
				}
				tmpNumber[back] = 0;
				isVisited[selectedIdx] = true;
			}
		}
		// 2. 곱하기를 계산한다.
		for (int i = 1; i < N; i += 2) {
			if (isVisited[i])
				continue; // 이미 계산한 건 패스
			if (oper[i] == '*') { // 곱하기일때만 계산
				int leftIdx = i - 1, rightIdx = i + 1;
				while (true) {
					if(leftIdx - 2 < 0) break;
					if(tmpNumber[leftIdx]==0) leftIdx-=2;
					else break;
				}
				while (true) {
					if(rightIdx + 2 >= N) break;
					if(tmpNumber[rightIdx]==0) rightIdx+=2;
					else break;
				}
				tmpNumber[leftIdx] *= tmpNumber[rightIdx];
				tmpNumber[rightIdx] = 0;
				isVisited[i] = true;
			}
		}
		// 3. 나머지를 계산한다.
		for (int i = 1; i < N; i += 2) {
			if(isVisited[i]) continue;
			int leftIdx = i - 1, rightIdx = i + 1;
			while (true) {
				if(leftIdx - 2 < 0) break;
				if(tmpNumber[leftIdx]==0) leftIdx-=2;
				else break;
			}
			while (true) {
				if(rightIdx + 2 >= N) break;
				if(tmpNumber[rightIdx]==0) rightIdx+=2;
				else break;
			}
			if(oper[i]=='+') {
				tmpNumber[leftIdx] += tmpNumber[rightIdx];
			}else {
				tmpNumber[leftIdx] -= tmpNumber[rightIdx];
			}
			tmpNumber[rightIdx] = 0;
			isVisited[i] = true;
		}
		// 4. 총합을 계산한다.
		int sum = 0;
		for(int i=0;i<N;++i) {
			sum += tmpNumber[i];
		}
		// 5. 갱신
		max = Math.max(max, sum);
	}

	static void find(int cnt, int start, int R, int[] select) {
		if (cnt == R) {
			calculate(select);
			return;
		}

		for (int i = start; i < N; i += 2) {
			if (cnt > 0 && (select[cnt - 1] + 2) == i)
				continue;
			select[cnt] = i;
			find(cnt + 1, i + 2, R, select);
		}
	}

}
