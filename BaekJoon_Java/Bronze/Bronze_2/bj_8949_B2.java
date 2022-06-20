package bronze;

import java.io.*;
import java.util.*;

public class bj_8949_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		int[] len = { A.length(), B.length() };
		Stack<String> answer = new Stack<>();
		while(len[0]!=0 && len[1]!=0) {
			answer.push(Integer.toString(Integer.parseInt(A.charAt(--len[0])+"")+Integer.parseInt(B.charAt(--len[1])+"")));
		}
		if(len[0]<len[1]) {
			while(len[1]!=0) answer.push(B.charAt(--len[1])+"");
		}else {
			while(len[0]!=0) answer.push(A.charAt(--len[0])+"");
		}
		
		while(!answer.isEmpty()) {
			System.out.print(answer.pop());
		}
	}

}
