#include <iostream>
#include<queue>
using namespace std;
int dir[2][8] = { {-1,1,0,0,-1,-1,1,1},{0,0,-1,1,-1,1,-1,1} };

class Cow {
public:
	int x, y;
	int dist;
	Cow(int _x, int _y, int _dist) {
		x = _x;
		y = _y;
		dist = _dist;
	}
};
int bMin(99999), dMin(99999);

bool isBoundary(int _x, int _y) {
	return 1 <= _x && _x <= 1000 && 1 <= _y && _y <= 1000;
}

void bfs(int _startX, int _startY, int _johnX, int _johnY, int &cnt, int direction) {
	queue<Cow> q;
	q.push(Cow(_startX, _startY, 0));
	bool isVisited[1001][1001] = { false };
	isVisited[_startX][_startY] = true;

	while (!q.empty()) {
		Cow now = q.front();
		q.pop();
		if (now.x == _johnX && now.y == _johnY) {
			cnt = now.dist;
			break;
		}
		for (int d = 0; d < direction; ++d) {
			int nx = now.x + dir[0][d];
			int ny = now.y + dir[1][d];
			if (isBoundary(nx, ny) && !isVisited[nx][ny]) {
				isVisited[nx][ny] = true;
				q.push(Cow(nx, ny, now.dist + 1));
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	pair<int, int> bessie;
	pair<int, int> daisy;
	pair<int, int> john;
	cin >> bessie.first >> bessie.second;
	cin >> daisy.first >> daisy.second;
	cin >> john.first >> john.second;

	if (bessie.first == daisy.first && bessie.second == daisy.second) cout << "tie";
	else {
		// bessie
		bfs(bessie.first, bessie.second, john.first, john.second,bMin,8);
		// daisy
		bfs(daisy.first, daisy.second, john.first, john.second,dMin,4);
		cout << (bMin < dMin ? "bessie" : (bMin > dMin ? "daisy" : "tie"));
	}
}