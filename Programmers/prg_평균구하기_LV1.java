package Programmers;

public class prg_평균구하기_LV1 {
	static public double solution(int[] arr) {
		double sum = 0.0;
		for (int a : arr)
			sum += a;
		double answer = sum / arr.length;
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,3,4}));
	}

}
