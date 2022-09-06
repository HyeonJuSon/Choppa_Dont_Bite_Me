#include<iostream>
using namespace std;

int getDouble(int target) {
	int answer = 1;
	for (int i = 2; i * i <= target; ++i) {
		int cnt = 0;
		while (target % i == 0) {
			++cnt;
			target /= i;
		}
		if (cnt % 2 == 1) answer *= i;
	}
	return target > 1 ? answer * target : answer;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int TC, A;
	scanf("%d", &TC);
	for (int tc = 1; tc <= TC; ++tc) {
		scanf("%d", &A);
		printf("#%d %d\n", tc, getDouble(A));
	}

	return 0;
}