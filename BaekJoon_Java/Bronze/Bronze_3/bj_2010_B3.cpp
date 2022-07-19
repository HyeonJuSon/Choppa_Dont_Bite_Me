#include<iostream>
using namespace std;

int main(void) {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N(0), now(0), val(0), sum(0);
    cin >> N;
    cin >> now;
    for (int i = 0; i < N - 1; ++i) {
        cin >> val;
        sum += now - 1;
        now = val;
    }
    sum += now;
    cout << sum;
    return 0;
}