package CodeUp91to100;

import java.io.*;
import java.util.*;

public class Main_Q_99 {
	static int[][] map = new int[10][10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] pos = { 1, 1 };
		if(map[1][1]== 2) {
			map[1][1] =9;
		}else{
			map[1][1] = 9;
			while (true) {

				if (map[pos[0]][pos[1] + 1] != 1) { // 오른쪽이동가능
					int val = map[pos[0]][pos[1] + 1];
					map[pos[0]][pos[1] + 1] = 9;
					pos[1]++;
					if (val == 2)
						break;
				} else if (map[pos[0]][pos[1] + 1] != 0 && map[pos[0] + 1][pos[1]] != 1) {
					int val = map[pos[0] + 1][pos[1]];
					map[pos[0] + 1][pos[1]] = 9;
					pos[0]++;
					if (val == 2)
						break;
				} else
					break;
			}
		}
		print();
	}

	static void print() {
		for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
