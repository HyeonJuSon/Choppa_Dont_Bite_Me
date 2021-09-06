package silver;

import java.io.*;
import java.util.*;
import java.io.*;

public class bj_2504_S2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<String> bracket = new Stack<>();
		int before = 0;
		String target = "()[]";
		boolean isPossible = true;
		for (int i = 0; i < input.length(); ++i) {
			if (!isPossible)
				break;
			String now = input.charAt(i) + "";
			switch (now) {
			case "(":
			case "[":
				if (before != 0) {
					bracket.push(Integer.toString(before));
					before = 0;
				}
				bracket.push(now); // tkqdlq
				break;
			case ")":
				if (bracket.isEmpty()) {
					isPossible = false;
					break;
				}
				if (bracket.peek().equals("(")) {
					if (before == 0)
						before = 2;
					else
						before *= 2;
					bracket.pop();
				} else if (!target.contains(bracket.peek())) { // 숫자가 들어있으면
					while (!bracket.isEmpty() && !target.contains(bracket.peek()))
						before += Integer.parseInt(bracket.pop());
					if (bracket.isEmpty())
						break;
					if (bracket.peek().equals("(")) {
						before *= 2;
						bracket.pop();
					} else {
						bracket.push(Integer.toString(before));
						before = 0;
					}
				} else
					isPossible = false;
				break;
			case "]":
				if (bracket.isEmpty()) {
					isPossible = false;
					break;
				}
				if (bracket.peek().equals("[")) {
					if (before == 0)
						before = 3;
					else
						before *= 3;
					bracket.pop();
				} else if (!target.contains(bracket.peek())) { // 숫자가 들어있으면
					while (!bracket.isEmpty() && !target.contains(bracket.peek()))
						before += Integer.parseInt(bracket.pop());
					if (bracket.isEmpty())
						break;
					if (bracket.peek().equals("[")) {
						before *= 3;
						bracket.pop();
					} else {
						bracket.push(Integer.toString(before));
						before = 0;
					}
				} else
					isPossible = false;
				break;
			}
		}
		if (!isPossible)
			System.out.println(0);
		else {
			if (!bracket.isEmpty()&&target.contains(bracket.peek())) {
				System.out.println(0);
			} else {
				while (!bracket.isEmpty())
					before += Integer.parseInt(bracket.pop());
				System.out.println(before);
			}
		}
	}

}
