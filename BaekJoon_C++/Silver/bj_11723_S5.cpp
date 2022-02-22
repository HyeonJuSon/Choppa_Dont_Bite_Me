#include<iostream>
#include<string>

using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int M(0);
    cin >> M;
    int Bit(0);
    for (int i = 0; i < M; ++i) {
        string order = "";
        cin >> order;
        int x(0);
        if (order == "add") {
            cin >> x;
            Bit |= (1 << x);
        }
        else if (order == "remove") {
            cin >> x;
            Bit &= ~(1 << x);
        }
        else if (order == "check") {
            cin >> x;
            if (Bit & (1 << x)) cout << 1 << '\n';
            else cout << 0 << '\n';
        }
        else if (order == "toggle") {
            cin >> x;
            Bit ^= (1 << x);
        }
        else if (order == "all") {
            Bit = (1 << 21) - 1;
        }
        else {
            Bit = 0;
        }
    }

    return 0;
}
