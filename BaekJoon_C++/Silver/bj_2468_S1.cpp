#include<iostream>
#include<algorithm>
#include<queue>
#include<cstring>
using namespace std;
int N;
bool is_visited[101][101];
void raining(int **arr, bool is_rain[][101], int rain) {
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			if (arr[i][j] <= rain) is_rain[i][j] = true;
		}
	}
}
int dir[4][4] = { {-1,1,0,0},{0,0,-1,1} };
bool is_boundary(int x, int y) {
	return 0 <= x && x < N && 0 <= y && y < N;
}
void bfs(int x, int y, bool is_rain[][101]) {
	queue<pair<int, int>> q;
	q.push({ x,y });

	while (!q.empty()) {
		pair<int, int> now = q.front();
		q.pop();
		for (int d = 0; d < 4; ++d) {
			int nx = now.first + dir[0][d];
			int ny = now.second + dir[1][d];
			if (is_boundary(nx, ny) && !is_rain[nx][ny] && !is_visited[nx][ny]) {
				is_visited[nx][ny] = true;
				q.push({ nx, ny });
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	// 배열 할당
	int **arr = new int* [N];
	for (int i = 0; i < N; ++i) {
		arr[i] = new int[N];
	}
	// 입력 
	int max_height(0);  
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			cin >> arr[i][j];
			max_height = max(max_height, arr[i][j]); // 최대 높이 체크
		}
	}
	// 비의 양 별로 반복한다.
	bool is_rain[101][101];
	int answer(0);
	for (int rain = 0; rain <= max_height; ++rain) {
		memset(is_rain, false, sizeof(is_rain));
		memset(is_visited, false, sizeof(is_visited));
		// 비를 내린다.
		raining(arr, is_rain, rain);
		// 안전 영역을 찾는다.
		int cnt(0);
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!is_rain[i][j]&&!is_visited[i][j]) {
					is_visited[i][j] = true;
					bfs(i, j,is_rain);
					++cnt;
					
				}
			}
		}
		// 최대값 갱신
		answer = max(answer, cnt);
	}
	cout << answer;
	// 할당 해제
	for (int i = 0; i < N; ++i) delete[] arr[i];
	delete[] arr;

	return 0;
}