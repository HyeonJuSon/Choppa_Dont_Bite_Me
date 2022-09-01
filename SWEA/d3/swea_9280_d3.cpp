#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int main(void) {

	int T, N, M, r,w;
	cin >> T;
	for (int tc = 1; tc <= T; ++tc) {
		cin >> N >> M;
		// 단위 무게 가격
		vector<int> R;
		R.clear();
		for (int i = 0; i < N; ++i) {
			cin >> r;
			R.push_back(r);
		}
		// 자동차 무게
		vector<int> W;
		W.clear();
		for (int i = 0; i < M; ++i) {
			cin >> w;
			W.push_back(w);
		}
		// 입/출차 기록 -> 하루에 한번씩 왓다갓다함 = M*2회
		int car_num;
		int park[100] = { };//최대 100
		fill_n(park, 100, -1);
		int money(0), value(0); // 수입
		queue<int> ready_car;//대기목록
		ready_car = queue<int>();
		for (int i = 0; i < 2 * M; ++i) {
			cin >> car_num;
			if (car_num < 0) { // 출차
				for (int j = 0; j < N; ++j) {
					if (park[j] == car_num * -1) {
						park[j] = -1; //출차
						// 대기 차있는지 확인
						if (!ready_car.empty()) {
							int ready = ready_car.front(); // 대기차 하나 뽑음
							ready_car.pop();
							park[j] = ready;
							value = R[j] * W[ready - 1];
							money += value;//수입 계산
						}
						break;
					}
				}
			}
			else { // 주차
				bool isfind = false;
				for (int j = 0; j < N; ++j) {
					if (park[j] == -1) {
						park[j] = car_num;
						value = R[j] * W[car_num - 1];
						money += value;//수입 계산
						isfind = true;
						break;
					}
				}
				if (!isfind) { // 대기해야함
					ready_car.push(car_num); // 대기 목록 등재
				}
			}
		}
		cout << "#" << tc << ' ' << money << '\n';
	}

	return 0;
}