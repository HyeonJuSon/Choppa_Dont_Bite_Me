import java.util.*;

public class prg_거리두기확인하기_Lv2 {
	static ArrayList<int[]> pos = new ArrayList<>();
	static public int[] solution(String[][] places) {
		int[] answer = new int[5];
		char[][] room = new char[5][5];//대기실 정보
		for (int i = 0; i < 5; ++i) {
			pos.clear();//리스트 초기화
			for (int j = 0; j < 5; ++j) {
				room[j] = places[i][j].toCharArray(); // 대기실 정보를 만들어주고
				for (int k = 0; k < 5; ++k) {
					if (room[j][k] == 'P') pos.add(new int[] { j, k }); // 사람잇으면 넣어준다.
				}
			}
			answer[i] = find(room);//검사시작
		}
		return answer;
	}

	static int find(char[][] room) {
		int size = pos.size();//인원 수
		if (size > 1) { // 사람이 2명이상일때만 검사한다.
			for (int i = 0; i < size - 1; ++i) {
				int[] me = pos.get(i);//나를 기준으로 검사해본다.
				for (int j = i + 1; j < size; ++j) {
					if (!isPossibleMdist(me, pos.get(j))) {//맨해튼거리 2이하이면 파티션을 검사한다.
						int[] you = pos.get(j); // 상대방의 위치
						// 1.같은행 or 열일때는 사이만 검사.
						if (me[0] == you[0]) { // 같은행 -> 열검사
							if (me[1] - you[1] < 0) { // 상대방이 나보다 오른쪽에 있다.
								if (room[me[0]][me[1] + 1] != 'X') return 0; // 어느 한쪽도 파티션이 없다.
							} else if (me[1] - you[1] > 0) { //상대방이 나보다 왼쪽에 있다.
								if (room[me[0]][me[1] - 1] != 'X') return 0; // 어느 한쪽도 파티션이 없다.
							} 
						} else if (me[1] == you[1]) { // 같은 열 -> 행검사
							if (me[0] - you[0] < 0) { // 상대방이 나보다 아래에 있다.
								if (room[me[0] + 1][me[1]] != 'X') return 0; // 어느 한쪽도 파티션이 없다.
							} else if (me[0] - you[0] > 0) { //상대방이 나보다 위에 있다.
								if (room[me[0] - 1][me[1]] != 'X') return 0; // 어느 한쪽도 파티션이 없다.
							}
						} else if (me[0] != you[0] && me[1] != you[1]) {// 다른 행,열일 경우
							if (me[0] > you[0]) {
								if (me[1] > you[1]) { // 왼,위 검사
									if (room[me[0]][me[1] - 1] != 'X' || room[me[0] - 1][me[1]] != 'X') return 0;
								} else if (me[1] < you[1]) {// 오,위
									if (room[me[0]][me[1] + 1] != 'X' || room[me[0] - 1][me[1]] != 'X') return 0;
								}
							} else if (me[0] < you[0]) {
								if (me[1] > you[1]) { // 왼, 아 검사
									if (room[me[0]][me[1] - 1] != 'X' || room[me[0] + 1][me[1]] != 'X') return 0;
								} else if (me[1] < you[1]) { // 오, 아 검사
									if (room[me[0]][me[1] + 1] != 'X' || room[me[0] + 1][me[1]] != 'X') return 0;
								} 
							}
						}
					}
				}
			}
		}
		return 1;
	}
	
	public static boolean isPossibleMdist(int[] a, int[] b) { // 2보다 크면 true 아니면 false
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]) > 2 ? true : false;
	}

	public static void main(String[] args) {
		String[][] target = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		int[] ans = solution(target);
		System.out.println(Arrays.toString(ans));
	}

}
