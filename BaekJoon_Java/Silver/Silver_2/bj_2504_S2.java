package silver;

import java.io.*;
import java.util.*;

public class bj_2504_S2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<String> bracket = new Stack<>();
		int before = 0;
		String target = "()[]";
		boolean isPossible = true;
		for (int i = 0; i < input.length(); ++i) {
			if (!isPossible) break; // 불가능하면 더이상 살펴 볼 필요 없음.
			String now = input.charAt(i) + "";
			switch (now) {
			case "(":
			case "[":
				if (before != 0) { // 숫자가 있으면 
					bracket.push(Integer.toString(before)); // 숫자를 스택에 넣어주고
					before = 0; // 비운다
				}
				bracket.push(now); // 여는 괄호 삽입.
				break;
			case ")":
				if (bracket.isEmpty()) { // 비어있는데 닫는 괄호가 들어오면 불가능.
					isPossible = false;
					break;
				}
				if (bracket.peek().equals("(")) { // 짝이 맞으면
					before = before == 0 ? 2 : before * 2; // 연달아 괄호면 2를 곱하고 아니면 2를 넣는다.
					bracket.pop(); // 비워준다.
				} else if (!target.contains(bracket.peek())) { // 숫자가 들어있으면
					while (!bracket.isEmpty() && !target.contains(bracket.peek())) // 안의 숫자를 다 더해준다.
						before += Integer.parseInt(bracket.pop());
					if (bracket.isEmpty()) break; // 비었으면 검사가 끝난 것이므로 break;
					if (bracket.peek().equals("(")) { // 짝이맞으면 곱해준다.
						before *= 2;
						bracket.pop();
					} else { // 짝이 맞지 않으면 숫자를 넣어준다.
						bracket.push(Integer.toString(before));
						before = 0;
					}
				} else // 아예 짝이 다른 경우 불가능
					isPossible = false;
				break;
			case "]":
				if (bracket.isEmpty()) { // 비어있는데 닫는 괄호가 들어오면 불가능.
					isPossible = false;
					break;
				}
				if (bracket.peek().equals("[")) { // 짝이맞으면 
					before = before == 0 ? 3 : before * 3; // 곱하거나 숫자를 넣거나
					bracket.pop(); // 비워준다.
				} else if (!target.contains(bracket.peek())) { // 숫자가 들어있으면
					while (!bracket.isEmpty() && !target.contains(bracket.peek())) // 다 더해준다.
						before += Integer.parseInt(bracket.pop());
					if (bracket.isEmpty()) break; // 비었으면 검사가 끝난 것이므로 break;
					if (bracket.peek().equals("[")) { // 짝이맞으면 곱해준다.
						before *= 3;
						bracket.pop();
					} else { // 짝이 안맞으면 숫자를 넣고 비워준다.
						bracket.push(Integer.toString(before));
						before = 0;
					}
				} else // 아예 짝이 다른 경우 불가능
					isPossible = false;
				break;
			}
		}
		if (!isPossible) // 아예 짝이 다른 경우 불가능
			System.out.println(0);
		else {
			if (!bracket.isEmpty() && target.contains(bracket.peek())) { // 숫자가아닌 경우 불가능.
				System.out.println(0);
			} else { // 숫자인 경우
				while (!bracket.isEmpty()) // 다 더해준다. (이미 다 더해진 경우에는 이 단계를 건너뜀)
					before += Integer.parseInt(bracket.pop());
				System.out.println(before);
			}
		}
	}

}
