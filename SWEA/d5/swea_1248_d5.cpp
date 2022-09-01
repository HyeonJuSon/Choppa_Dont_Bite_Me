#include<iostream>
#include<string>
using namespace std;

struct Node {
	char oper;
	int num;
	int left;
	int right;
} tree[1001];

int calculate(int idx) {
	if (tree[idx].num != -1) return tree[idx].num;
	int a = calculate(tree[idx].left);
	int b = calculate(tree[idx].right);
	switch (tree[idx].oper) {
	case '+': return a + b;
	case '-': return a - b;
	case '/': return a / b;
	case '*':return a * b;
	default: return -1;
	}
	return -1;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N, idx, L, R;
	for (int tc = 1; tc <= 10; ++tc) {
		cin >> N;
		for (int i = 0; i < N; ++i) {
			cin >> idx;
			string tmp;
			cin >> tmp;
			// input
			if ('0' <= tmp[0] && tmp[0] <= '9') {
				tree[idx].num = stoi(tmp);
			}
			else {
				cin >> L >> R;
				tree[idx].oper = tmp[0];
				tree[idx].left = L;
				tree[idx].right = R;
				tree[idx].num = -1;
			}
		}
		// output
		cout << '#' << tc << ' ' << calculate(1) << '\n';
	}

	return 0;
}