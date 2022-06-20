package bronze;
import java.util.*;
public class bj_1100_B2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		boolean[][] map = new boolean[8][8];
		for(int i=0;i<8;++i) { // 체스판 입력
			String now = sc.next();
			for(int j=0;j<8;++j) {
				if(now.charAt(j)=='F') 
					map[i][j] = true;
			}
		}
		int cnt =0;
		for(int i=0;i<8;++i) {
			for (int j=0;j<8;++j) {
				if(i%2 ==0 && j%2 ==0&&map[i][j]) { // 짝수행에는 짝수열이 흰색
					++cnt;
				}else if(i%2!=0 &&j%2!=0&&map[i][j]){ // 홀수 행에는 홀수 열이 흰색
					++cnt;
				}
			}
		}
		System.out.println(cnt);
	}

}
