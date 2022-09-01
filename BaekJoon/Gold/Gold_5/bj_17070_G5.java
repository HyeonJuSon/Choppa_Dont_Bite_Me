import java.io.*;
import java.util.*;

public class bj_17070_G5 {

	static final int garo = 0;
	static final int sero = 1;
	static final int daegak = 2;
	static int N, arr[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(garo, 0, 1);
		System.out.println(cnt);
	}

	static int cnt = 0;
	static void dfs(int type, int x, int y) {
		if (x == N - 1 && y == N - 1) { // 기저조건
			cnt++;
			return;
		}

		switch (type) {
		case garo:
			// 가로
			if (isAvailable(x, y + 1) && arr[x][y + 1] == 0)
				dfs(garo, x, y + 1);
			// 대각선
			if (isAvailable(x + 1, y + 1) && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0)
				dfs(daegak, x + 1, y + 1);

			break;
		case sero:
			// 세로
			if (isAvailable(x + 1, y) && arr[x + 1][y] == 0)
				dfs(sero, x + 1, y);
			// 대각선
			if (isAvailable(x + 1, y + 1) && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0)
				dfs(daegak, x + 1, y + 1);
			break;
		case daegak:
			// 가로
			if (isAvailable(x, y + 1) && arr[x][y + 1] == 0)
				dfs(garo, x, y + 1);
			// 세로
			if (isAvailable(x + 1, y) && arr[x + 1][y] == 0)
				dfs(sero, x + 1, y);
			// 대각선
			if (isAvailable(x + 1, y + 1) && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0)
				dfs(daegak, x + 1, y + 1);
			break;
		}
	}

	static boolean isAvailable(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
