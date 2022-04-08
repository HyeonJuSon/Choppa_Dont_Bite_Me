package gold;

import java.io.*;
import java.util.*;

public class bj_17140_G4 {

	static int r, c, k, map[][];

	static class Value implements Comparable<Value> {
		int cnt, val;

		Value(int cnt, int val) {
			this.cnt = cnt;
			this.val = val;
		}

		@Override
		public int compareTo(Value o) {
			if (this.cnt == o.cnt) { // 등장횟수 같으면 숫자 오름차순
				return Integer.compare(this.val, o.val);
			}
			// 등장횟수 오름차순
			return Integer.compare(this.cnt, o.cnt);
		}
	}
	
	static void print() {
		for(int i=0;i<R;++i) {
			for(int j=0;j<C;++j) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static int R = 3, C = 3;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// array index start 0
		--r;
		--c;
		int time = 0;
		if (R>r&&C>c&&map[r][c] == k)
			System.out.println(time);
		else {
			boolean fail = false;
			while (true) {
				int newRow = 0;
				int newCol = 0;
				int[][] tmp = null;
				if (R >= C) { // R 연산
					tmp = new int[R][C * 2];// R연산으로 최대 C*2개까지 늘어날수있음
					for (int i = 0; i < R; ++i) {
						HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
						for (int j = 0; j < C; ++j) {
							int val = map[i][j];
							if(val==0)continue;
							hm.put(val, hm.getOrDefault(val, 0) + 1);
						}
						// 정렬해준다.
						PriorityQueue<Value> sort = new PriorityQueue<>();
						for (Integer key : hm.keySet()) {
							sort.add(new Value(hm.get(key), key));
						}
						// 길이 측정
						newCol = Math.max(newCol, sort.size()*2);

						// 정렬된 것을 배열에 담아준다.
						for (int j = 0; j < C * 2; j += 2) {
							if (sort.isEmpty())
								break;
							Value now = sort.poll();
							tmp[i][j] = now.val;
							tmp[i][j + 1] = now.cnt;
						}
					}
				} else { // C 연산
					tmp = new int[R * 2][C];
					for (int j = 0; j < C; ++j) {
						HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
						for (int i = 0; i < R; ++i) {
							int val = map[i][j];
							if(val == 0) continue;
							hm.put(val, hm.getOrDefault(val, 0) + 1);
						}
						// 정렬해준다.
						PriorityQueue<Value> sort = new PriorityQueue<>();
						for (Integer key : hm.keySet()) {
							sort.add(new Value(hm.get(key), key));
						}
						// 길이 측정
						newRow = Math.max(newRow, sort.size()*2);
						// 정렬된 것을 배열에 담아준다.
						for (int i = 0; i < R * 2; i += 2) {
							if (sort.isEmpty())
								break;
							Value now = sort.poll();
							tmp[i][j] = now.val;
							tmp[i+1][j] = now.cnt;
						}
					}
				}
				++time;
				if (R >= C) {
					C = newCol;
					map = new int[R][C];
					for (int i = 0; i < R; ++i) {
						for (int j = 0; j < C; ++j) {
							map[i][j] = tmp[i][j];
						}
					}
				} else {
					R = newRow;
					map = new int[R][C];
					for (int i = 0; i < R; ++i) {
						for (int j = 0; j < C; ++j) {
							map[i][j] = tmp[i][j];
						}
					}
				}
				if (R>r&&C>c && map[r][c] == k)
					break;
				if(time >=100) {
					fail = true;
					break;
				}
			}
			
			System.out.println(fail?-1:time);
		}
	}

}
