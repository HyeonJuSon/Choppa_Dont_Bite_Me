#include<iostream>
using namespace std;
int arr[5][5];
bool isVisited[26] = { false }; // 1~25

bool is_bingo() {
    int bingo_cnt(0);
    bool flag;
    // 가로
    for (int i = 0; i < 5; ++i) {
        flag = true;
        for (int j = 0; j < 5; ++j) {
            if (!isVisited[arr[i][j]]) {
                flag = false;
                break;
            }
        }
        if (flag)
            ++bingo_cnt;
    }
    // 세로
    for (int j = 0; j < 5; ++j) {
        flag = true;
        for (int i = 0; i < 5; ++i) {
            if (!isVisited[arr[i][j]]) {
                flag = false;
                break;
            }
        }
        if (flag)
            ++bingo_cnt;
    }
    // 우하향 대각선
    int x(0), y(0);
    flag = true;
    while (x < 5) {
        if (!isVisited[arr[x++][y++]]) {
            flag = false;
            break;
        }
    }
    if (flag)
        ++bingo_cnt;
    // 좌하향 대각선
    flag = true;
    x =0, y = 4;
    while (y>= 0) {
        if (!isVisited[arr[x++][y--]]) {
            flag = false;
            break;
        }
    }
    if (flag)
        ++bingo_cnt;

    return bingo_cnt >= 3;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for (int i = 0; i < 5; ++i) {
        for (int j = 0; j < 5; ++j) {
            cin >> arr[i][j];
        }
    }

    int cnt(0), val(0);
    for (int i = 0; i < 5; ++i) {
        for (int j = 0; j < 5; ++j) {
            ++cnt;
            cin >> val;
            isVisited[val] = true;
            if (is_bingo()) {
                cout << cnt;
                return 0;
            }
        }
    }

    return 0;
}