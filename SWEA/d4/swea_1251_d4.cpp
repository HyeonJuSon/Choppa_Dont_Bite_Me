#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

typedef long long ll;

ll getParent(int link[], ll A) {
	if (link[A] == A) return A;
	return link[A] = getParent(link, link[A]);
}

int findLink(int link[], ll A, ll B) {
	A = getParent(link, A);
	B = getParent(link, B);
	if (A == B) return 1;
	return 0;
}

void unionLink(int link[], ll A, ll B) {
	A = getParent(link, A);
	B = getParent(link, B);
	if (A < B) link[B] = A;
	else link[A] = B;
}

class Edge {
public:
	ll from;
	ll to;
	ll cost;
	Edge(ll from, ll to, ll cost) {
		this->from = from;
		this->to = to;
		this->cost = cost;
	}
	bool operator <(Edge& edge) {
		return this->cost < edge.cost;
	}
};


int main() {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int T, N;
	double E;

	cin >> T;

	for (int tc = 1; tc <= T; ++tc) {
		cin >> N;
		vector<ll> X;
		vector<ll> Y;
		X.clear(); Y.clear();
		// input
		ll tmp;
		for (int i = 0; i < N; ++i) {
			cin >> tmp;
			X.push_back(tmp);
		}
		for (int i = 0; i < N; ++i) {
			cin >> tmp;
			Y.push_back(tmp);
		}
		cin >> E;
		// info
		vector<Edge> islands;
		islands.clear();
		for (ll i = 0; i < N-1; ++i) {
			for (ll j = i+1; j < N; ++j) {
				ll L2 = (X[i] - X[j]) * (X[i] - X[j]) + (Y[i] - Y[j]) * (Y[i] - Y[j]);
				islands.push_back(Edge(i, j, L2));
			}
		}
		// kruskal
		sort(islands.begin(), islands.end());

		int link[1000] = {0,};
		for (int i = 0; i <N; ++i) link[i] = i;
		
		ll answer = 0;
		for (int i = 0; i < islands.size(); ++i) {
			if (!findLink(link, islands[i].from, islands[i].to)) {
				answer += islands[i].cost;
				unionLink(link, islands[i].from, islands[i].to);
			}
		
		}
		// print
		printf("#%d %0.lf\n", tc, answer * E);
	}

	return 0;
}