#include<iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(0);
	cout.tie(0);
	cin.tie(0);

	string input;
	cin >> input;

	int N = input.length();
	int cnt[26] = {0,};
	for (int i = 0; i < N; ++i) {
		++cnt[input[i] - 'A'];
	}
	int c = 0;
	for (int i = 0; i < 26; ++i) {
		if (cnt[i] % 2 == 1) ++c;
	}
	bool pelin = c <= 1;
	if (pelin) {
		string answer;
		// pelin front
		for (int i = 0; i < 26; ++i)
			for (int j = 0; j < cnt[i] / 2; ++j)
				answer += i + 'A';
		// pelin mid
		for (int i = 0; i < 26; ++i)
			if (cnt[i] % 2==1)
				answer += i + 'A';
		// pelin back
		for (int i = 25; i >= 0; --i)
			for (int j = 0; j < cnt[i] / 2; ++j)
				answer += i + 'A';
		cout << answer;
	}
	else {
		cout << "I'm Sorry Hansoo\n";
	}
		
	return 0;
}