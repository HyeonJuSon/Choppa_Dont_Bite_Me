#include<iostream>
using namespace std;

int main() {
    int N;
    cin >> N;

    for (int tc = 1; tc <= N; ++tc) {
        string input;
        cin >> input;
        int len = input.length();
        cout <<( (6 <= len && len <= 9) ? "yes" : "no" )<<'\n';
    }

    return 0;

}