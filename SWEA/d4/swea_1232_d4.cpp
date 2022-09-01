#include<iostream>
using namespace std;

struct Node {
	char val;
	int left;
	int right;
} tree[100];

string answer;

void Inorder(int idx) {
	if (tree[idx].left != -1) Inorder(tree[idx].left);
	answer += tree[idx].val;
	if (tree[idx].right != -1) Inorder(tree[idx].right);
	return;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N, idx, left, right;
	char val;

	for (int tc = 1; tc <= 10; ++tc) {
		cin >> N;
		// 입력 받기
		for (int i = 0; i < N; ++i) {
			cin >> idx >> val;
			
			left = -1, right = -1;
			if (cin.get() != '\n') {
				cin >> left;
				if (cin.get() != '\n') cin >> right;
			}

			tree[idx].val = val;
			tree[idx].left = left;
			tree[idx].right = right;
		}
		answer = "";
		Inorder(1);
		cout << '#' << tc << ' '<<answer<<'\n';
	}

	return 0;
}