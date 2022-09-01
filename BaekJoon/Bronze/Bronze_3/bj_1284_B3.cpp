#include<iostream>
using namespace std;

int GetWidth(int num) {
	if (num == 0) return 4;
	else if (num == 1) return 2;
	else return 3;
}

int main(void) {
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	string input;
	while (true) {
		cin >> input;
		if (input == "0") break;
		int sum = input.length()+1;
		for (int i = 0; i < input.length(); ++i) {
			sum += GetWidth(input[i]-'0');
		}
		cout << sum<<'\n';
	}
	return 0;
}