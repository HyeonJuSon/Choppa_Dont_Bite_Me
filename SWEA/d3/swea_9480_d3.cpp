#include<iostream>
using namespace std;

int alpha[26];
string words[15];//1-15
int answer;


void dfs(int idx, int cnt, int end, int N, bool isVisited[]) {
	if (cnt == end) {
		fill_n(alpha, 26, 0);
		for (int i = 0; i < N; ++i) {
			if (isVisited[i]) {
				for (int j = 0; j < words[i].size(); ++j) {
					++alpha[words[i][j] - 97];
				}
			}
		}

		for (int i = 0; i < 26; ++i) {
			if (alpha[i] == 0) return;
		}

		++answer;
		return;
	}

	for (int i = idx; i < N; ++i) {
		if (isVisited[i]) continue;
		isVisited[i] = true;
		dfs(i, cnt + 1, end, N, isVisited);
		isVisited[i] = false;
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int T, N;
	bool isVisited[15];
	cin >> T;
	for (int tc = 1; tc <= T; ++tc) {
		cin >> N;
		for (int i = 0; i < N; ++i) {
			cin >> words[i];
		}
		answer = 0;
		fill_n(isVisited,15, false);

		for (int i = 1; i <= N; ++i) {
			dfs(0, 0, i,N,isVisited);
		}
		printf("#%d %d\n", tc, answer);
	}

	return 0;
}