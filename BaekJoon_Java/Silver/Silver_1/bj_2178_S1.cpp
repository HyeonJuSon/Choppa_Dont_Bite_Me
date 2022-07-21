#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;

int N, M;
int map[100][100] = { 0 };
int dist[100][100] = { 0 };
int dir[2][4] = { {-1,1,0,0},{0,0,-1,1} };

bool isBoundary(int x, int y) {
	return 0 <= x && x < N && 0 <= y && y < M;
}

void bfs() {
	queue<pair<int,int>> q;
	bool isVisited[100][100] = { false };
	isVisited[0][0] = true;
	dist[0][0] = 1;
	q.push({ 0,0 });
	while (!q.empty()) {
		int now[2] = { q.front().first, q.front().second };
		q.pop();
		
		for (int d = 0; d < 4; ++d) {
			int nx = now[0] + dir[0][d];
			int ny = now[1] + dir[1][d];
			if (isBoundary(nx, ny) && !isVisited[nx][ny] && map[nx][ny] == 1) {
				isVisited[nx][ny] = true;
				dist[nx][ny] = dist[now[0]][now[1]] + 1;
				q.push({ nx,ny });
			}
		}
	}

}

int main() {
	// 입력
	cin >> N >> M;
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < M; ++j) {
			scanf_s("%1d", &map[i][j]);
		}
	}
	// bfs
	bfs();
	// print
	cout << dist[N - 1][M - 1];
	return 0;
}