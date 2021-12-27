
public class prg_음양더하기_LV1 {
	static public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int i = 0; i < absolutes.length; ++i) {
			boolean sign = signs[i];
			int val = absolutes[i];
			if (!sign)
				val *= -1;
			answer += val;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {4,7,12}, new boolean[] {true, false, true}));
	}

}
