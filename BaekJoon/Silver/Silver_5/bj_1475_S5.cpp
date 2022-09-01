#include<iostream>
#include<string>
using namespace std;

int main() {
	int arr[10] = { 0 };
	string str = "";
	cin >> str;
	for (int i = 0; i < str.length(); ++i) {
		arr[str.at(i) - '0']++;
	}
	
	int val = (arr[6] + arr[9]);
	if (val % 2 == 0) {
		arr[6] = arr[9] = val / 2;
	}
	else {
		arr[6] = arr[9] = val / 2 + 1;
	}

	int max = 0;
	for (int a : arr) if (max < a) max = a;
	cout << max;

	return 0;
}