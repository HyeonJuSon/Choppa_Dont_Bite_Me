#include<iostream>
#include<string>
#include<stack>
using namespace std;

int main() {
	int T;
	cin >> T;
	cin.ignore(); // delete buffer
	for (int i = 0; i < T; ++i) {
		string input;
		getline(cin, input);
		input += ' ';
		stack<char> st;
		for (int i = 0; i < input.size(); ++i) {
			if (input[i] == ' ') {
				while (!st.empty()) {
					cout << st.top();
					st.pop();
				}
				cout << ' ';
			}
			else st.push(input[i]);
		}
		cout << "\n";
		
	}
	return 0;
}