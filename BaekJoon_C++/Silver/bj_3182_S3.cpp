#include<iostream>
using namespace std;

bool* isVisited;
int* arr;
int maxCnt(0), target(0);
bool isflag;
int T;
void dfs(int cnt, int idx) {
	if (isVisited[idx]) {
		if (maxCnt < cnt) {
			maxCnt = cnt;
			isflag = true;
		}
		return;
	}
	isVisited[idx] = true;
	dfs(cnt + 1, arr[idx]);

}
void reset_visit() {
	for (int i = 0; i < T; ++i) isVisited[i] = false;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> T;
	arr = new int[T];
	for (int t = 0; t < T; ++t) {
		cin >> arr[t];
		arr[t]--; 
	}

	isVisited = new bool[T];
	for (int i = 0; i < T; ++i) {
		reset_visit();
		isflag = false;
		dfs(0, i);
		if (isflag) target = i + 1;
	}
	cout << target;
	
	return 0;
}