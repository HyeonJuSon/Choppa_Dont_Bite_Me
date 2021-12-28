package Programmers;

public class prg_x만큼간격이있는n개의숫자_LV1 {
	static public long[] solution(int x, int n) {
		long[] answer = new long[n];
		answer[0] = x;
		for (int i = 1; i < n; ++i)
			answer[i] = answer[i - 1] + x;
		return answer;
	}

	public static void main(String[] args) {
		long[] answer = solution(-10000000, 1000);
		for (long a : answer)
			System.out.print(a + " ");
	}

}
