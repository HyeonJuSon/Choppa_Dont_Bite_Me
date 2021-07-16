import java.io.*;
import java.util.*;

public class prg_괄호회전하기_Lv2 {

	static public int solution(String s) {
		int answer = 0; // 하나도 없으면 0임
		String target = s; // 복사본 초기화
		for (int x = 0; x < target.length(); ++x) { // x는 0부터 길이-1까지
			if(valid(target)) ++answer; // valid하면 카운팅
			target = target.substring(1) + target.charAt(0);// 스와핑
		}
		return answer;
	}
	
	static boolean valid(String target) {
		Stack<Character> st = new Stack<>();// 유효성 검사용
		for(int i=0;i<target.length();++i) {//문자열 전체 검사
			char val = target.charAt(i);//현재 문자
			if(st.isEmpty()) st.push(val);//비어있으면 바로 푸쉬
			else {//비어있지 않다면 (peek할때 비어있으면 안되서 안에넣음)
				char top = st.peek();//스택 맨위 거를 보고 짝이 맞으면 pop 안맞으면 push
				if((val == ']' && top == '[')||(val=='}'&&top=='{')||(val==')'&&top=='('))
					st.pop();
				else st.push(val);
			}
		}
		return st.isEmpty();//비어있으면 유효한거고 안비면 안유효
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(solution("[](){}"));
	}

}
