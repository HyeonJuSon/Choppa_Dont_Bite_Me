#include<iostream>
#include<algorithm>
#include<queue>
using namespace std;

int answer(999999999);
void dfs(int cnt, int s, int t);
int main() {

	// 연속 발차기 
	// 1. A 점수 2배, B 점수 += 3
	// 2. B 점수 += 1
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T(0);
	cin >> T;
	for (int t = 0; t < T; ++t) {
		int S(0), T(0);
		cin >> S >> T;
		dfs(0, S, T);
		cout << answer <<'\n';
		answer = 999999999;
	}
	return 0;
}

void dfs(int cnt, int s, int t) {

	if (s > t) return; // s가 t보다 커지면 return
	if (s == t) { // s가 t와 같아지면 갱신 후 return
		answer = min(cnt, answer);
		return;
	}

	for (int i = 0; i < 2; ++i) {
		if (i == 0)
			dfs(cnt + 1, s * 2, t + 3);
		else
			dfs(cnt + 1, s + 1, t);
	}

}