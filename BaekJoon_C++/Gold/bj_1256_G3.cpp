#include<iostream>
#include<string>
using namespace std;

int dp[101][101];
string output;
int check(int a, int z) {
	if (a == 0 || z == 0) return 1;
	if (dp[a][z] != 0) return dp[a][z];
	return dp[a][z] = min(check(a - 1, z) + check(a, z - 1), 1000000001);
}
void find(int a, int z, int k) {
	if (a == 0) {
		for (int i = 0; i < z; ++i) output += 'z';
		return;
	}
	if (z == 0) {
		for (int i = 0; i < a; ++i) output += 'a';
		return;
	}
	int val = check(a - 1, z);
	if (val < k) {
		output += 'z';
		find(a, z - 1, k - val);
	}
	else {
		output += 'a';
		find(a - 1, z, k);
	}
}

int main(void) {
	int N, M,K;
	cin >> N >> M >> K;
	find(N, M, K);

	if (check(N, M) < K) cout << -1 << '\n';
	else cout << output << '\n';

	return 0;
}
