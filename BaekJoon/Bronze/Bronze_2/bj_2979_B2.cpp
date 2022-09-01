#include<iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(0);
	cout.tie(0);
	cin.tie(0);

	int A, B, C;
	cin >> A >> B >> C;
	B *= 2;
	C *= 3;
	int cnt[100] = { 0, };
	int max = 0;
	for (int i = 0; i < 3; ++i) {
		int start, end;
		cin >> start >> end;
		while (start < end) {
			++cnt[start++ - 1];
		}
		if (max < end) max = end;
	}
	int sum = 0;
	for (int i = 0; i < max; ++i) {
		if (cnt[i] == 1) sum += A;
		else if (cnt[i] == 2) sum += B;
		else if( cnt[i]==3) sum += C;
	}
	cout << sum;
	return 0;
}