
public class prg_lv2_로또의최고순위와최저순위 {

	static public int[] solution(int[] lottos, int[] win_nums) {
		int[] rotto = new int[46]; // 1-45가 로또번호
		for (int i = 0; i < win_nums.length; ++i) {
			rotto[win_nums[i]] = 1; // 로또 당첨번호 플래그 on
		}

		int nowScore = 0;
		int unknown = 0;
		int high = 0 , low = 0;
		for (int i = 0; i < lottos.length; ++i) {
			if (lottos[i] == 0) { // 알 수 없는 곳이라면
				++unknown;
			} else {

				if (rotto[lottos[i]] == 1) { // 만약 당첨 번호라면
					++nowScore;
				}
			}
		}
		// 1-6, 2-5, 3-4,4-3,5-2,6
		high = nowScore+unknown >= 6 ? 6 : nowScore+unknown;
		low = unknown == 6 ? 0 : nowScore;
		high = high == 0 ? 6 : Math.abs(high-7);
		low = low == 0 ? 6 : Math.abs(low-7);
		
		return new int[] {high,low};
	}

	public static void main(String[] args) {
		int[] answer = solution(new int[] { 44, 1, 0, 0, 31, 25 }, new int[] { 31, 10, 45, 1, 6, 19 });
		System.out.println(answer[0]+","+answer[1]);
	}

}
