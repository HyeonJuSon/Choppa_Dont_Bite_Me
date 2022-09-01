package bj;

import java.io.*;
import java.util.*;

public class bj_1929_S2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer (br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[] noPrimes = new boolean[m+1];
		// 소수 아닌 수 거르기 x의 배수는 소수가 아님.
		for(int i=2; i<=m; ++i) {
			if(!noPrimes[i]) {
				for(int j = i*2; j <= m; j+=i) {
					noPrimes[j] = true;
				}
			}
		}
		//0,1도 소수가 아님.
		noPrimes[0] = true;
		noPrimes[1] = true;
		
		// 소수 출력
		for(int i=n; i<=m;++i) {
			if(!noPrimes[i]) sb.append(i).append('\n');
		}
		System.out.println(sb);
	}

}
