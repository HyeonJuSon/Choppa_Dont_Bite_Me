#include<iostream>
#include<string>
#include<fstream>
#include<algorithm>
#include<stack>
using namespace std;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string str("");
    getline(cin, str);
    string answer("");
    stack<char> st;
    reverse(str.begin(), str.end());
    for (int i = 0; i < str.length(); ++i) st.push(str.at(i));
    bool flag = false;
    stack<char> tmp;
    while (!st.empty()) {
        char now = st.top();
        st.pop();
        if (flag) { // pop한 now값을 바로 붙인다.
            if (now == '>') {
                flag = false;
            }
                answer += now;
        }
        else { // 다시 tmp 스택에 넣는다.
            if (now == '<') {
                flag = true; // flag를 올려준다.
                while (!tmp.empty()) {
                    answer += tmp.top();
                    tmp.pop();
                }
                answer += now;
            }
            else if (now == ' ') {
                while (!tmp.empty()) {
                    answer += tmp.top();
                    tmp.pop();
                }
                answer += now;
            }
            else {
                tmp.push(now); // tmp 스택에 넣는다.
            }
        }
    }
    while (!tmp.empty()) {
        answer += tmp.top();
        tmp.pop();
    }

    cout << answer;
    return 0;
}