package gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_14891_G5 {

	static final int red = 0, left = 6, right = 2; // 화살표, 좌/우측 닿이는 인덱스
	static int[][] gears;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		gears = new int[4][8];
		for (int i = 0; i < 4; ++i) { // 톱니바퀴 정보 입력
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < 8; ++j) {
				gears[i][j] = tmp[j]-'0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		Queue<int[]> orders = new LinkedList<>(); // 톱니 바퀴 회전 명령을 나타낼 큐
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine(), " ");// 기어번호 -1해서 받는다 -> 배열이므로 1번기어는 0번배열
			orders.offer(new int[] { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) });
		}

		while (!orders.isEmpty()) { // 모든 회전명령을 수행할때 까지 시행한다.
			int[] current = orders.poll();
			int gearNum = current[0]; // 돌리려는 기어의 번호
			int dir = current[1];// 돌리려는 방향 -> 1: 시계방향 2:반시계방향

			// 1. 돌리기 전에 gearNum 에 해당하는 기어가 움직여질 때 추가로 같이 움직여지는 기어가 있는 지 검사한다.
			Queue<int[]> rotGear = new LinkedList<>(); // 추가로 돌려져야할 기어 번호를 담을 큐
			if (dir == 1) {// 시계방향
				// 현재 기어 기준 기어 전체에서 좌 우측을 검사해서 추가로 돌려질 기어가 있는 지 검사
				// 검사는 현재 기준 기어에서 1(우)-2(좌) 2(우)-3(좌) 3(우)-4(좌) 번 기어끼리 검사하면 된다.
				switch (gearNum) {
				case 0: // 1번회전시 2번 무조건
					if (gears[0][right] != gears[1][left]) { // 2번이 돌려지는지 확인
						rotGear.offer(new int[] { 1, -1 });
						if (gears[1][right] != gears[2][left]) { // 2번이 돌려질때 3번 확인
							rotGear.offer(new int[] { 2, 1 });
							if (gears[2][right] != gears[3][left]) { // 3번이 돌려질때 4번 확인
								rotGear.offer(new int[] { 3, -1 });
							}
						}
					}
					break;
				case 1: // 2번 회전시 1번과 3번은 무조건
					if (gears[0][right] != gears[1][left])
						rotGear.offer(new int[] { 0, -1 });
					if (gears[1][right] != gears[2][left]) { // 3번이 움직여지는지 확인
						rotGear.offer(new int[] { 2, -1 });
						if (gears[2][right] != gears[3][left])
							rotGear.offer(new int[] { 3, 1 });
					}
					break;
				case 2: // 3번 회전시 2번과 4번은 무조건
					if (gears[3][left] != gears[2][right])
						rotGear.offer(new int[] { 3, -1 });
					if (gears[1][right] != gears[2][left]) { // 2번이 움직여지는지 확인
						rotGear.offer(new int[] { 1, -1 });
						if (gears[0][right] != gears[1][left])
							rotGear.offer(new int[] { 0, 1 });
					}
					break;
				case 3: // 4번 회전시 3번 무조건
					if (gears[3][left] != gears[2][right]) {
						rotGear.offer(new int[] { 2, -1 });
						if (gears[2][left] != gears[1][right]) {
							rotGear.offer(new int[] { 1, 1 });
							if (gears[1][left] != gears[0][right]) {
								rotGear.offer(new int[] { 0, -1 });
							}
						}
					}
					break;
				}
			} else if (dir == -1) { // 반시계 방향
				switch (gearNum) {
				case 0: // 1번회전시 2번 무조건
					if (gears[0][right] != gears[1][left]) { // 2번이 돌려지는지 확인
						rotGear.offer(new int[] { 1, 1 });
						if (gears[1][right] != gears[2][left]) { // 2번이 돌려질때 3번 확인
							rotGear.offer(new int[] { 2, -1 });
							if (gears[2][right] != gears[3][left]) { // 3번이 돌려질때 4번 확인
								rotGear.offer(new int[] { 3, 1 });
							}
						}
					}
					break;
				case 1: // 2번 회전시 1번과 3번은 무조건
					if (gears[0][right] != gears[1][left])
						rotGear.offer(new int[] { 0, 1 });
					if (gears[1][right] != gears[2][left]) { // 3번이 움직여지는지 확인
						rotGear.offer(new int[] { 2, 1 });
						if (gears[2][right] != gears[3][left])
							rotGear.offer(new int[] { 3, -1 });
					}
					break;
				case 2: // 3번 회전시 2번과 4번은 무조건
					if (gears[3][left] != gears[2][right])
						rotGear.offer(new int[] { 3, 1 });
					if (gears[1][right] != gears[2][left]) { // 2번이 움직여지는지 확인
						rotGear.offer(new int[] { 1, 1 });
						if (gears[0][right] != gears[1][left])
							rotGear.offer(new int[] { 0, -1 });
					}
					break;
				case 3: // 4번 회전시 3번 무조건
					if (gears[3][left] != gears[2][right]) {
						rotGear.offer(new int[] { 2, 1 });
						if (gears[2][left] != gears[1][right]) {
							rotGear.offer(new int[] { 1, -1 });
							if (gears[1][left] != gears[0][right]) {
								rotGear.offer(new int[] { 0, 1 });
							}
						}
					}
					break;
				}
			}
			// 2. 현재 기어를 돌린다.
			boolean isClockwise = dir == 1 ? true : false;
			gearMove(isClockwise, gearNum);

			// 3. 추가로 돌려하는 기어를 돌린다.
			while (!rotGear.isEmpty()) {
				int[] curRot = rotGear.poll();
				boolean isClockwise2 = curRot[1] == 1 ? true : false;
				gearMove(isClockwise2, curRot[0]);
			}
		}
		// 4. 점수를 계산한다.
		System.out.println(getScore());
	}

	private static int getScore() {
		int a = gears[0][0] == 0 ? 0 : 1;
		int b = gears[1][0] == 0 ? 0 : 2;
		int c = gears[2][0] == 0 ? 0 : 4;
		int d = gears[3][0] == 0 ? 0 : 8;
		return a + b + c + d;
	}

	static void gearMove(boolean isClockwise, int gearNum) {
		if (isClockwise) {// 시계방향
			int val = gears[gearNum][7]; // 마지막 값을 저장,
			for (int j = 6; j >= 0; --j) {
				gears[gearNum][j + 1] = gears[gearNum][j];
			}
			gears[gearNum][0] = val;
		} else {
			int val = gears[gearNum][0]; // 첫번째 값을 저장
			for (int i = 1; i < 8; ++i) {
				gears[gearNum][i - 1] = gears[gearNum][i];
			}
			gears[gearNum][7] = val;
		}
	}

}
