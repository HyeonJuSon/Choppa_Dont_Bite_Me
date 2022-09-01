#include<iostream>
#include<algorithm>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(0);
	cout.tie(0);
	cin.tie(0);

	int score[1000];
	int N, K;
	cin >> N >> K;
	for (int i = 0; i < N; ++i) {
		cin >> score[i];
	}
	sort(score, score + N, greater<>());
	cout << score[K - 1];
	return 0;
}