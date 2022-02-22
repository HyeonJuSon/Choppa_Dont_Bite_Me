#include<iostream>
#include<string>
#include<math.h>
using namespace std;


int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string A, B;
    cin >> A >> B;
    int answer(50);
    if (A.length() == B.length()) {
        answer = 0;
        for (int i = 0; i < A.length(); ++i) {
            if (A.at(i) != B.at(i))
                ++answer;
        }
    }
    else {
        string word[2];
        int len[2];
        const int BIG = 0, SMALL = 1;
        if (A.length() > B.length()) {
            word[BIG] = A;
            word[SMALL] = B;
            len[BIG] = A.length();
            len[SMALL] = B.length();
        }
        else {
            word[BIG] = B;
            word[SMALL] = A;
            len[BIG] = B.length();
            len[SMALL] = A.length();
        }
        int idx = 0;
        while (true) {
            if (idx + len[SMALL] > len[BIG])
                break;
            int j = idx++;
            int cnt = 0;
            for (int i = 0; i < len[SMALL]; ++i) {
                if (word[BIG].at(j++) != word[SMALL].at(i))
                    ++cnt;
            }
            answer = min(answer, cnt);
        }
    }
    cout << answer;
    return 0;
}