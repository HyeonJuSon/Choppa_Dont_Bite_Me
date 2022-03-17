package gold;

import java.util.Scanner;

public class bj_16463_S4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] day = new int[13];
		day[1] = day[3] = day[5] = day[7] = day[8] = day[10] = day[12] = 31;
		day[2] = 28;
		day[4] = day[6] = day[9] = day[11] = 30;

		int startYear = 2019;
		int mon = 1;
		int friday = 4;
		int answer = 0;
		while (true) {
			// À±³â Ã¼Å©
			if (startYear % 400 == 0 || (startYear % 100 != 0 && startYear % 4 == 0)) {
				day[2] = 29;
			} else
				day[2] = 28;

			root : for (int i = 0; i < 12; ++i) {
				for (int j = 1; j <= 5; ++j) {
					friday += 7;
					if (friday > day[mon]) {
						friday -= day[mon++];
						if(mon>12) break root;
					}else {
						if(friday==13) ++answer;
					}
				}
			}
			if(mon>12) {
				mon=1;
				++startYear;
			}
			
			if(startYear > N) break;
		}
		System.out.println(answer);
	}

}
