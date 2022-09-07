#include<iostream>
typedef unsigned long long ull;
#define MOD 1000000007
using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int T;
	cin >> T;

	int N, answer, L, R, input[2000],sum;
	ull K, a, b;


	for (int tc = 1; tc <= T; ++tc) {
		cin >> N >> K;
		for (int i = 0; i < N; ++i) cin >> input[i];
		sum = 0;
		for (int i = 0; i < N; ++i) {
			L = R = 0;
			for (int j = 0; j < i; ++j) {
				if (input[j] < input[i]) ++L;
			}
			for (int j = i + 1; j < N; ++j) {
				if (input[j] < input[i]) ++R;
			}
			// 등차수열합
			a = ((K - 1) * K / 2 % MOD * (L + R)) % MOD;
			b = (R * K) % MOD;
			sum += (a + b) % MOD;
			sum %= MOD;
		}
		cout << "#" << tc << ' ' << sum << '\n';
	}

	return 0;
}