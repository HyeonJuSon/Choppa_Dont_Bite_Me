
public class PRG_다트게임_LV1 {

	static int getScore(int val, char bonus) {
		int tmp = val;
		switch (bonus) {
		case 'S':
			break;
		case 'D':
			tmp = tmp * tmp;
			break;
		case 'T':
			tmp = tmp * tmp * tmp;
			break;
		}
		return tmp;
	}

	static public int solution(String dartResult) {
		int answer = 0;
		int[] scores = new int[3];
		int idx = 0;
		String val = "";
		for (int i = 0; i < dartResult.length(); ++i) {
			char now = dartResult.charAt(i);
			if (now == '*' || now == '#') { // 옵션
				if (now == '*') {
					if (idx - 2 < 0) {
						scores[idx - 1] *= 2;
					}
					else {
						scores[idx - 1] *= 2;
						scores[idx - 2] *= 2;
					}
				} else { // 자기 자신 
					if(idx - 1 < 0) scores[idx] *= -1;
					else scores[idx - 1] *=-1;
				}
			} else if (now == 'S' || now == 'D' || now == 'T') { // 보너스
				scores[idx] = Integer.parseInt(val);
				val = "";
				scores[idx] = getScore(scores[idx], now);
				idx++;
			} else { // 점수
				val += now;
			}
		}

		for (int a : scores)
			answer += a;
		return answer;
	}

	public static void main(String[] args) {
		String dartResult = "1S2D*3T";
		System.out.println(solution(dartResult));
	}

}
