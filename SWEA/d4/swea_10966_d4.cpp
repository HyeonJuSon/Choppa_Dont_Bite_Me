#include<iostream>
#include<queue>
using namespace std;

int N, M;
int map[1000][1000];

bool isBoundary(int x, int y) {
	return 0 <= x && x < N && 0 <= y && y < M;
}

int main() {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int dir[2][4] = { {-1,1,0,0},{0,0,-1,1} };
	int T;
	cin >> T;
	string input;
	for (int tc = 1; tc <= T; ++tc) {
		cin >> N >> M;
		queue<pair<int, int>> bfs;
		for (int i = 0; i < N; ++i) {
			cin >> input;
			for (int j = 0; j < M; ++j) {
				map[i][j] = -1;
				if (input.at(j) == 'W') {
					bfs.push(make_pair(i,j));
					map[i][j] = 0;
				}
			}
		}
		// find
		while (!bfs.empty()) {
			pair<int,int> cur = bfs.front();
			bfs.pop();
			for (int d = 0; d < 4; ++d) {
				int nx = cur.first+dir[0][d];
				int ny = cur.second+dir[1][d];
				if (isBoundary(nx, ny) && map[nx][ny] ==-1) {
					map[nx][ny] = map[cur.first][cur.second] + 1;
					bfs.push(make_pair(nx,ny));
				}
			}
		}
		// sum
		int sum = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				sum += map[i][j];
			}
		}
		//print
		cout << "#" << tc << ' ' << sum << '\n';
	}


	return 0;
}