#include<iostream>
#include<cstring>
using namespace std;
int answer(0);
int R, C, K;

bool is_boundary(int x, int y) {
	return 0 <= x && x < R && 0 <= y && y < C;
}

int dir[4][4] = { {-1,1,0,0},{0,0,-1,1} };
void dfs(int x, int y, int depth,int **map,  bool is_visited[][5]) {
	if (depth > K) return;
	
	if (x == 0 && y == C - 1 && depth == K) {
		++answer;
		return;
	}
	

	for (int d = 0; d < 4; ++d) {
		int nx = x + dir[0][d];
		int ny = y + dir[1][d];
		if (is_boundary(nx, ny) && !is_visited[nx][ny] && map[nx][ny] == 0) {
			is_visited[nx][ny] = true;
			dfs(nx, ny, depth + 1, map, is_visited);
			is_visited[nx][ny] = false;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> R >> C >> K;
	int** map = new int* [R];
	for (int i = 0; i < R; ++i) {
		map[i] = new int[C];
		memset(map[i], 0, sizeof(int) * C);
	}
	for (int i = 0; i < R; ++i) {
		string str; 
		cin >> str;
		for (int j = 0; j < C; ++j) {
			if (str.at(j) == 'T') map[i][j] = 1;
		}
	}
	bool is_visited[5][5];
	memset(is_visited, false, sizeof(is_visited));
	is_visited[R - 1][0] = true;
	dfs(R-1, 0, 1,map, is_visited);

	cout << answer;



	for (int i = 0; i < R; ++i) delete[] map[i];
	delete[] map;

	return 0;
}