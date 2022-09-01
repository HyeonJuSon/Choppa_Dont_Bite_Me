#include<iostream>
using namespace std;
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N(0);
    cin >> N;
    int sum(0);
    int plus(1);
    int target(10);
    for (int i = 1; i <= N; ++i) {
        if (i * 1 >= target) {
            target *= 10;
            plus++;
        }
            sum += plus;
    }
    cout << sum;

    return 0;
}