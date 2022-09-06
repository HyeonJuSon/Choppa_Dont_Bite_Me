#include<iostream>
using namespace std;

int main() {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int TC, N, M;
	cin >> TC;
	for (int tc = 1; tc <= TC; ++tc) {
		cin >> N >> M;
		bool on = true;
		for (int i = N-1; i >=0; --i) {
			int now = M & (1 << i) ? 1:0;
			cout << now;
			if (now == 0) {
				on = false;
				break;
			}
		}
		cout << '\n';
		printf("#%d %s\n", tc, on ? "ON" : "OFF");
	}

	return 0;
}