#include<iostream>
#include<algorithm>
using namespace std;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N(0), M(0), K(0);
    cin >> N >> M >> K;
    cout << min(min((N / 2), M), (N + M - K) / 3);
    return 0;
}