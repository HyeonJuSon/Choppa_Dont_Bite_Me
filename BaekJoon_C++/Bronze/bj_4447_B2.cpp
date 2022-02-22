#include<iostream>
#include<string>
using namespace std;


int main() {
	int T;
	cin >> T;
	cin.ignore();
	for (int i = 0; i < T; ++i) {
		
		string input;
		getline(cin, input);
		int gCnt(0), bCnt(0);
		for (int s = 0; s < input.length(); ++s) {
			char now = input.at(s);
			if (now == 'g'|| now=='G') ++gCnt;
			else if (now == 'b' || now=='B') ++bCnt;
		}
		input += " is ";
		string output = gCnt > bCnt ? "GOOD" : (gCnt < bCnt ? "A BADDY" : "NEUTRAL");
		cout << input << output<<endl;
	}
}