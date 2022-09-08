#include<iostream>
using namespace std;
int LCS[501][501];
int main() {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int T, N;
	string a, b;
	cin >> T;

	for (int tc = 1; tc <= T; ++tc) {
		cin >> N;
		cin >> a >> b;
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				if (a.at(i - 1) == b.at(j - 1))
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				else
					LCS[i][j] = LCS[i - 1][j] > LCS[i][j - 1] ? LCS[i - 1][j] : LCS[i][j - 1];
			}
		}
		printf("#%d %.2f\n", tc, ((float)LCS[N][N] / N) * 100);
	}
	return 0;
}