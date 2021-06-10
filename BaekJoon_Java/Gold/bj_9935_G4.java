package gold;

import java.util.*;
import java.io.*;

public class bj_9935_G4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();// 입력문자열
		String target = br.readLine();// 폭발문자열
		System.out.println(process(input, target));
	}

	static String process(String input, String target) {
		Stack<Character> stack = new Stack<>(); // 스택 선언
		int targetLen = target.length();//폭발문자열
		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
			if (stack.size() >= targetLen) {
				boolean flag = true;
				for (int j = 0; j < targetLen; j++) { // 폭발 문자열 길이만큼 비교해서 하나라도 다르면 false
					if (stack.get(stack.size() - targetLen + j) != target.charAt(j)) {
						flag = false;// 스택길이가 5인데 인덱스 1부터 비교하려면, targetLen빼주면됌
						break;		// 그리고 그 인덱스에서부터 한칸씩 증가해야하니까 +j 해준다.
					}
				}
				if (flag) { // 폭발 문자열이라면
					for (int j = 0; j < targetLen; j++) stack.pop(); // 스택에서 빼준다.
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Character ch : stack) { // 하나씩 더해주고
			sb.append(ch);
		}
		return sb.toString().length()==0?"FRULA":sb.toString();// 반환해준다.

	}
}
