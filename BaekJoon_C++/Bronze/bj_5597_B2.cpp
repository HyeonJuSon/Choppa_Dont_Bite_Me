#include<iostream>
#include<queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    bool check[31] = { false };
    for (int i = 0; i < 28; ++i) {
        int val(0);
        cin >> val;
        check[val] = true;
    }
    priority_queue<int, vector<int>, greater<int>> pq;
    for (int i = 1; i <= 30; ++i) {
        if (!check[i])
            pq.push(i);
    }
    for (int i = 0; i < 2; ++i) {
        cout << pq.top() << '\n';
        pq.pop();
    }

    return 0;
}