package bronze;

import java.io.*;
import java.util.*;

public class bj_1259_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = br.readLine();
			if(input.equals("0")) break;
			Deque<Character> dq = new ArrayDeque<>();
			for(int i=0;i<input.length();++i) {
				dq.push(input.charAt(i));
			}
			boolean isEven = input.length()%2==0 ;
			boolean isFelin = true;
			if(isEven) {
				while(!dq.isEmpty()) {
					char front = dq.pollFirst();
					char back = dq.pollLast();
					if(front!=back) {
						isFelin = false;
						break;
					}
				}
			}else {
				while(dq.size()>1) {
					char front = dq.pollFirst();
					char back = dq.pollLast();
					if(front!=back) {
						isFelin = false;
						break;
					}
				}
			}
			System.out.println(isFelin ? "yes":"no");
		}
	}

}
