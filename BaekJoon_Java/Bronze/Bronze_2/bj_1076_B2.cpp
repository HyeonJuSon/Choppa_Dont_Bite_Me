#include<iostream>
#include<map>
#include<vector>
using namespace std;

int get_value(string color, bool on) {
    if (color == "black") {
        return on ? 0 : 1;
    }
    else if (color == "brown") {
        return on ? 1 : 10;
    }
    else if (color == "red") {
        return on ? 2 : 100;
    }
    else if (color == "orange") {
        return on ? 3 : 1000;
    }
    else if (color == "yellow") {
        return on ? 4 : 10000;
    }
    else if (color == "green") {
        return on ? 5 : 100000;
    }
    else if (color == "blue") {
        return on ? 6 : 1000000;
    }
    else if (color == "violet") {
        return on ? 7 : 10000000;
    }
    else if (color == "grey") {
        return on ? 8 : 100000000;
    }
    else if (color == "white") {
        return on ? 9 : 1000000000;
    }
    return -1;
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int front(0);
    long long answer(0);
    string A(""), B(""), C("");
    cin >> A >> B >> C;
    front = (get_value(A, true) * 10) + get_value(B, true);
    answer = (long long)front * get_value(C, false);
    cout << answer;
    return 0;
}