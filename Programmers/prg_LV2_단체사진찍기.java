package Programmers;

import java.util.*;

public class prg_LV2_단체사진찍기 {
	static class Operation {
		char to;
		char oper;
		int val;

		Operation(char to, char oper, int val) {
			this.to = to;
			this.oper = oper;
			this.val = val;
		}
	}
	static int answer =0 ;
	static HashMap<Character, ArrayList<Operation>> condition = new HashMap<>();
	static char[] people = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	static int R = 8;

	static public int solution(int n, String[] data) {
		answer = 0;
		condition.clear();
		for (int i = 0; i < data.length; ++i) {
			String now = data[i];
			char from = now.charAt(0);
			char to = now.charAt(2);
			char oper = now.charAt(3);
			int val = now.charAt(4)-'0';
			ArrayList<Operation> tmp;
			if (condition.containsKey(from)) {
				tmp = condition.get(from);
			} else {
				tmp = new ArrayList<>();
			}
			tmp.add(new Operation(to, oper, val));
			condition.put(from, tmp);
		}
		comb(0, "", new boolean[R]);
		return answer;

	}

	static void comb(int cnt, String input, boolean[] isVisited) {
		if (cnt == R) {
			boolean isPossible=true;
			root : for (int i = 0; i < R; ++i) {
				char now = input.charAt(i);
				// 조건이 있다면
				if (condition.containsKey(now)) {
					ArrayList<Operation> op = condition.get(now);
					for (int o = 0; o < op.size(); ++o) {
						char target = op.get(o).to;
						char oper = op.get(o).oper;
						int val = op.get(o).val;
						int dist = Math.abs(i-input.indexOf(target))-1;
						if(oper =='>' && val >= dist) {
							isPossible=false;
							break root;
						}else if(oper == '<' && val <= dist) {
							isPossible=false;
							break root;
						}else if(oper=='=' && val !=dist) {
							isPossible =false;
							break root;
						}
					}
				}
			}
			if(isPossible) {
				++answer;
			}
			return;
		}
		for (int i = 0; i < R; ++i) {
			if (isVisited[i])
				continue;
			isVisited[i] = true;
			comb(cnt + 1, input + people[i], isVisited);
			isVisited[i] = false;
		}
	}

	public static void main(String[] arppgs) {
		int n = 2;
		String[] data = { "N~F=0", "R~T>2" };
		System.out.println(solution(n, data));
	}

}
