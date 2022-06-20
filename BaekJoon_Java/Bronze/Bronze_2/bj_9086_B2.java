package bronze;

import java.io.*;
import java.util.*;

public class bj_9086_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수를 입력받는다.
		for(int i=0;i<T;++i) {
			String input = br.readLine();
			sb.append(input.charAt(0)).append(input.charAt(input.length()-1)).append('\n');
		}
		System.out.println(sb.toString());
	}

}
