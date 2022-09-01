package gold;
import java.io.*;
import java.util.*;
public class bj_17845_G5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // 최대 공부시간
		int K = Integer.parseInt(st.nextToken()); // 과목의 개수
		
		int[] times = new int[K+1]; 			// 공부시간 정보
		int[] importance = new int[K+1]; 		// 중요도 정보
		int[][] D = new int[K+1][N+1]; 			// 공부시간 만들때 최대가치
		
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			importance[i] = Integer.parseInt(st.nextToken());
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= K; i++) { // 첫 과목부터 고려
			for (int n = 1; n <= N; n++) { // 중요도1부터 고려
				if(times[i]<=n) { // 수업을 들을 수 있다.
					// 넣을까 ,// 말까
					D[i][n] = Math.max(D[i-1][n-times[i]]+importance[i], D[i-1][n]);
					
				}else { // 수업을 못들을 경우
					D[i][n] = D[i-1][n];
				}
			}
		}
		
		System.out.println(D[K][N]);
		
	}

}
