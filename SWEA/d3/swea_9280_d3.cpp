#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int main(void) {

	int T, N, M, r,w;
	cin >> T;
	for (int tc = 1; tc <= T; ++tc) {
		cin >> N >> M;
		// ���� ���� ����
		vector<int> R;
		R.clear();
		for (int i = 0; i < N; ++i) {
			cin >> r;
			R.push_back(r);
		}
		// �ڵ��� ����
		vector<int> W;
		W.clear();
		for (int i = 0; i < M; ++i) {
			cin >> w;
			W.push_back(w);
		}
		// ��/���� ��� -> �Ϸ翡 �ѹ��� �Ӵٰ����� = M*2ȸ
		int car_num;
		int park[100] = { };//�ִ� 100
		fill_n(park, 100, -1);
		int money(0), value(0); // ����
		queue<int> ready_car;//�����
		ready_car = queue<int>();
		for (int i = 0; i < 2 * M; ++i) {
			cin >> car_num;
			if (car_num < 0) { // ����
				for (int j = 0; j < N; ++j) {
					if (park[j] == car_num * -1) {
						park[j] = -1; //����
						// ��� ���ִ��� Ȯ��
						if (!ready_car.empty()) {
							int ready = ready_car.front(); // ����� �ϳ� ����
							ready_car.pop();
							park[j] = ready;
							value = R[j] * W[ready - 1];
							money += value;//���� ���
						}
						break;
					}
				}
			}
			else { // ����
				bool isfind = false;
				for (int j = 0; j < N; ++j) {
					if (park[j] == -1) {
						park[j] = car_num;
						value = R[j] * W[car_num - 1];
						money += value;//���� ���
						isfind = true;
						break;
					}
				}
				if (!isfind) { // ����ؾ���
					ready_car.push(car_num); // ��� ��� ����
				}
			}
		}
		cout << "#" << tc << ' ' << money << '\n';
	}

	return 0;
}