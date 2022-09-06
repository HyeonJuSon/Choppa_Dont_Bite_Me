#include<iostream>
#include<vector>
#include<string>
using namespace std;

int V, E;
int adj[1001][1001], child_cnt[1001], parent_cnt[1001];
int answer[1001], a, b;
int main()
{
    for (int tc = 1; tc <= 10; tc++)
    {
        cin >> V >> E;
        for (int i = 1; i <= V; i++)
            child_cnt[i] = 0;
        for (int i = 0; i < E; i++)
        {
            int p, c;
            cin >> p >> c;
            adj[p][child_cnt[p]++] = c;
            parent_cnt[c]++;
        }
        a = 0, b = -1;
        for (int i = 1; i <= V; i++)
            if (!parent_cnt[i])
                answer[++b] = i;
        cout << "#" << tc << ' ';
        while (a <= b)
        {
            int t = answer[a++];
            cout << t << ' ';
            for (int i = 0; i < child_cnt[t]; i++)
            {
                int next = adj[t][i];
                if (--parent_cnt[next] == 0)
                    answer[++b] = next;
            }
        }
        cout << '\n';
    }
    return 0;
}