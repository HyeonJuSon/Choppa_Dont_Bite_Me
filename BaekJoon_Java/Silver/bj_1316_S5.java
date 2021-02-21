package bj;
import java.util.*;
public class bj_1316_S5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		// 입력 준비
		int N = Integer.parseInt(sc.nextLine());	// 개수 입력
		int totalCnt = 0;							// 그룹단어총개수
		for(int i=0; i<N;++i) {						// 반복
			boolean[] isVisited = new boolean[26];	// 이미 나온 단어인지
			boolean isError = false;				// 에러 체크
			char[] tmp = sc.nextLine().toCharArray();
			char before = tmp[0];					// 직전 문자
			for(int x = 0; x<tmp.length;++x) {		// 반복
				if(isVisited[tmp[x]-'a'] && before != tmp[x]) {
					isError =true;					// 이미방문했고, 직전과다르면 에러
					break;							// for문 탈출
				}		
				before = tmp[x];					// 직전단어 갱신
				isVisited[tmp[x]-'a'] = true;		// 방문체크(소문자이므로 -'a')
			}
			if(!isError) totalCnt++;				// 카운팅
		}	
		System.out.println(totalCnt);				// 출력
		sc.close();
	}

}
