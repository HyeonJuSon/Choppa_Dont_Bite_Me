package bj;
import java.util.*;
public class bj_7568_S5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// 입력 준비
		StringBuilder sb = new StringBuilder();	// 출력 준비
		int N = sc.nextInt();					// 사람 수 
		int[][] people = new int[N][2];			// 배열 할당
		for(int i=0;i<N;++i) {					// 정보 입력
			people[i][0] = sc.nextInt();
			people[i][1] = sc.nextInt();
		}	
		for(int[] p : people) {					// 등수 비교 시작
			int cnt = 0;
			for(int [] p2: people) {			// 몸무게,키가 나보다 더크면 카운팅
				if(p != p2) {					// 내 자신 X
					if(p[0] < p2[0] && p[1] < p2[1]) cnt++;
				}
			}
			sb.append(cnt+1).append(" ");		// 출력 저장
		}			
		System.out.println(sb);					// 출력
		sc.close();
	}
}
