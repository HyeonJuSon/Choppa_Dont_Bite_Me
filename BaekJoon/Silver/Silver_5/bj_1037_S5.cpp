#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int cnt(0);
	cin >> cnt;
	int* arr = new int[cnt];
	for (int i = 0; i < cnt; ++i) {
		cin >> arr[i];
	}
	sort(arr, arr + cnt, greater<int>());
	cout << arr[0]*arr[cnt-1];
	return 0;
}