#include<iostream>
#include<set>
typedef unsigned long long ull;
#define MAX 20
using namespace std;

string S;
ull fact[MAX+1];// max : 20 
ull answer;
int alpha[26] = {0,}; // A-Z

ull calc(int length) {
	ull answer = fact[length];
	for (int i = 0; i < 26; ++i) {
		if (alpha[i] > 1) answer /= fact[alpha[i]];
	}
	return answer;
}

int main() {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	// fact init
	fact[0] = fact[1] = 1; // 0!=1!=1
	for (int i = 2; i <= MAX; ++i) fact[i] = fact[i - 1] * i;
	// input
	int T;
	cin >> T;
	// test case
	for (int tc = 1; tc <= T; ++tc) {
		cin >> S;
		for (char ch : S) ++alpha[ch - 'A'];

		int length = S.length();
		answer = 0;
		
		for (char ch : S) {
			--length;
			int start = ch - 'A' - 1;
			for (int i = start; i >= 0; --i) {
				if (alpha[i] == 0) continue;
				--alpha[i];
				answer += calc(length);
				++alpha[i];
			}
			--alpha[ch - 'A'];
		}
		cout << "#" << tc << ' ' << answer << '\n';
	}
	return 0;
}
