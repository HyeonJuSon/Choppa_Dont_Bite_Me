/*
 * n의 최대값이 500000이므로 0-9까지의 버튼으로 만들 수 있는 최대 번호는 999999이다.
 * 가능성은 두 경우로 나눈다. 
 * 			1) +, - 로만 이동했을 때 -> 그냥 Math.abs(N-100)하면된다.
 * 			2) 가장 차이 적은 위치 +, -로 했을 때
 * 				- 완탐으로 0~999999까지 숫자를 만들어서 차이를 계산.
 * 			3) 찾는 수가 100일 때 -> 젤 좋지.
 * 1. n과 비교해서 n과의 차이가 가장 작은 애를 저장한다.
 * 		(비교하는 수는 한자리씩 고장여부를 검사한다.)
 * 2. Math.abs(가장가까운 수 - N) + 자리값 
 */
import java.io.*;
import java.util.*;

public class bj_1107_G5 {

	static int N;
	static boolean[] broken ;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 찾으려고 하는 목표 타겟
		broken = new boolean[10]; // 0 - 9 까지의 버튼 중 고장난 애 true
		int brokeCnt = Integer.parseInt(br.readLine()); // 고장난 개수
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < brokeCnt; ++i) {
			broken[Integer.parseInt(st.nextToken())] = true; // 고장났으면 true로 해준다.
		}
		if(N==100) System.out.println(0); // N = 100이면 그냥 바로 0 출력
		else System.out.println(process());//과정처리 후 출력
	}


	static int process() {
		int min = Integer.MAX_VALUE; // 최소값
		String now = "", close=""; // 현재 만들어본 숫자 값, 가장 가까운 값
		
		// 1. 그냥 바로 빼보기 
		int plusMinus = Math.abs(N-100);
		// 2. 0 ~ 999999에서 N과 가장 가까운 수를 찾아보기
		for(int i=0;i<1000000;++i) {
			now = Integer.toString(i);//현재 만들어본 숫자를 string으로 저장
			int nowCnt = Math.abs(N-Integer.parseInt(now));//현재 횟수
			if(!isBroken(now) && min > nowCnt) { // 고장난 버튼이 없고 더 적은 횟수를 가지면
				min = nowCnt; // 최소횟수를 갱신해준다.
				close = now; // 근접한 값을 갱신해준다.
			}
		}
		// 3. 더 작은 횟수 비교해서 출력해준다.
		if(close.equals("")) return plusMinus; // 근접한 값을 찾지 못했으면 plusMinus반환
		else // 근접한 값이 있으면 plusMinus랑 비교해서 더작은 값 반환
			return Math.min(plusMinus, Math.abs(N-Integer.parseInt(close)) + close.length());
	}
	
	static boolean isBroken(String val) { // 고장난 버튼이 포함되어있는지 반환해주는 메소드
		for(int i=0;i<val.length();++i) { // 조합한 숫자 하나하나 검사해보기
			int num = val.charAt(i)-'0';
			if(num >=10 || num<0) continue;
			if(broken[num]) return true; // 고장난 버튼 포함 시 true 반환
		}
		return false; // 고장난 것 없으면 false 반환
	}

}
