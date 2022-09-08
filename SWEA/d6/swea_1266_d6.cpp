#include<iostream>
using namespace std;
#define MAX 18
int comb(int N, int R);

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int prime[7] = { 2, 3, 5, 7, 11, 13, 17 };
	int T;
	cin >> T;
	for (int tc = 1; tc <= T; ++tc) {
		int A, B;
		cin >> A >> B;
		double AA[2][MAX + 1];
		double BB[2][MAX + 1];
		double Ap = 0.0, Bp = 0.0;

		AA[0][1] = (double)A / 100;
		AA[1][1] = (double)(100 - A) / 100;

		BB[0][1] = (double)B / 100;
		BB[1][1] = (double)(100 - B) / 100;

		for (int i = 2; i <= MAX; ++i) {
			AA[0][i] = AA[0][i - 1] * AA[0][1];
			AA[1][i] = AA[1][i - 1] * AA[1][1];
			BB[0][i] = BB[0][i - 1] * BB[0][1];
			BB[1][i] = BB[1][i - 1] * BB[1][1];
		}

		for (int i = 0; i < 7; ++i) {
			int c = comb(MAX, prime[i]);
			Ap += c * AA[0][prime[i]] * AA[1][MAX - prime[i]];
			Bp += c * BB[0][prime[i]] * BB[1][MAX - prime[i]];
		}
		double answer = (1.0 - Ap) * (1.0 - Bp);
		printf("#%d %lf\n", tc, 1.0 - answer);
	}


	return 0;
}

int comb(int N, int R) {
	if (N - R < R) R = N - R;
	int answer = 1;
	for (int i = 1; i <= R; ++i) {
		answer = answer * N-- / i;
	}
	return answer;
}