package bj;

import java.io.*;
/*
 * [ IDEA ]
 * 2의 배수로 이루어져 있으므로. 4등분씩 계속....
 * 분할정복 아이디어.
 */

public class bj_1992 {
	static int[][] arr; 					// 영상 배열 N*N
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Int(br.readLine());			// 영상 배열의 크기
		arr = new int[N][N]; 				// 영상 배열 할당
		for(int i=0; i < N; i++) {			// 영상 배열 입력
            String str = br.readLine();
            for(int j=0; j < N; j++) {
                arr[i][j] = Int(str.substring(j, j+1));
            }
        }
		divide(N, 0, 0);					//분할 정복 시작
		System.out.println(sb);				//출력
	}

	// 분할을 위한 메소드 
	static void divide(int n, int x, int y) {
		if(isPossible(n, x, y)) {			//전부다 같은 숫자로 되어있다면
            sb.append(arr[x][y]);			//스트링 빌더에 등록
        }else {
        	int half = n/2;					//반씩 줄어든다. 8..4...2...
        	sb.append("(");
            divide(half, x, y);				//시작 위치 (0,0)
            divide(half,x, y + half);		//시작 위치 (0,half)
            divide(half, x + half, y);		//시작 위치 (half,0)
            divide(half, x + half, y + half);//시작 위치 (half,half)
            sb.append(")");
        }
	}
	// 모두 같은 숫자인지를 판별하는 메소드
	static boolean isPossible(int n, int x, int y) {
		int tmp = arr[x][y];				// 하나를 미리 받아두고.
		for (int i = x; i < x + n; i++) 
			for (int j = y; j < y + n; j++) // 하나라도 다르면 안되므로 false
				if (tmp != arr[i][j]) return false; 
		return true;						//위에서 안 걸렸으므로 모두 같음. true
	}
	// Int로 변환해주는 메소드
	static int Int(String s) {
		return Integer.parseInt(s);
	}
	
}
