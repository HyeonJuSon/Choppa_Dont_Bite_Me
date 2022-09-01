#include<iostream>
#include<string>
#include<fstream>
using namespace std;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string str("");
    getline(cin, str);
    string answer("");
    for (int i = 0; i < str.length(); ++i) {
        char now = str.at(i);
        if (('a' <= now && now <= 'z')) {
            if (now <= 'm') now += 13;
            else now -= 13;
        }
        else if ('A' <= now && now <= 'Z') {
            if (now <= 'M') now += 13;
            else now -= 13;
        }
        answer += now;
    }
    cout << answer;
    return 0;
}