#include<iostream>
#include<map>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;
	map<string, int> m;
	for (int i = 0; i < N; ++i) {
		string input;
		cin >> input;
		if (m.count(input)>0) {
			m[input]++;
		}
		else m.insert({ input,1 });
	}
	int max_val(0);
	string answer;
	for (auto iter = m.begin(); iter != m.end(); ++iter) {
		if (max_val < iter->second) {
			max_val = iter->second;
			answer = iter->first;
		}
		else if (max_val == iter->second) {
			if (iter->first.compare(answer) < 0) {
				answer = iter->first;
			}
		}
	}
	cout << answer;
	return 0;
}