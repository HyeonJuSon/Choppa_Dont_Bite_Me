#include<iostream>
#include<string>
#include<queue>
using namespace std;




int R, C;
int dir[2][4] = { {-1, 1, 0, 0}, {0, 0, -1, 1} };
char** map;
bool** isVisited;
queue<pair<int, int>> wolves;
const int wolf = 1, sheep = 0;

bool isBoundary(int x, int y) {
    return 0 <= x && x < R && 0 <= y && y < C;
}

void dfs(pair<int, int> now, int& w, int& s) {
    isVisited[now.first][now.second] = true;
    for (int d = 0; d < 4; ++d) {
        int nx = now.first + dir[0][d];
        int ny = now.second + dir[1][d];
        if (isBoundary(nx, ny) && map[nx][ny] != '#' && !isVisited[nx][ny]) {
            if (map[nx][ny] == 'v') ++w;
            else if(map[nx][ny]=='o') ++s;
            dfs(make_pair(nx, ny),w,s);
        }
    }
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> R >> C;
    map = new char* [R];
    isVisited = new bool* [R];
    for (int i = 0; i < R; ++i) {
        map[i] = new char[C];
        isVisited[i] = new bool[C];
        fill(&isVisited[i][0], &isVisited[i][C - 1], false);
    }
    
    int cnt[2] = {0};
    // 입력 
    for (int i = 0; i < R; ++i)
    {
        string input;
        cin >> input;
        for (int j = 0; j < C; ++j)
        {
            map[i][j] = input.at(j);
            if (map[i][j] == 'v') {
                ++cnt[wolf];
                wolves.push(make_pair(i, j));
            }
            else if (map[i][j] == 'o')
                ++cnt[sheep];
        }
    }

    while (!wolves.empty()) {
        pair<int, int> now = wolves.front();
        wolves.pop();
        int w(1), s(0);
        dfs(now,w,s);
        if (w < s)   cnt[wolf] -=w;
        else cnt[sheep] -= s;
    }

    cout << cnt[sheep] << ' ' << cnt[wolf];

    // 해제
    for (int i = 0; i < R; ++i)
    {
        delete[] map[i];
    }
    delete[] map;

    return 0;
}
