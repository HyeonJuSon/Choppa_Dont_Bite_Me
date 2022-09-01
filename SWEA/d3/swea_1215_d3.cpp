#include <iostream>
#include <vector>
using namespace std;
const int N = 8;

int main(void)
{
    for (int tc = 1; tc <= 10; tc++)
    {
        int lenth; 
        cin >> lenth;

        vector<string> drom;
        for (int x = 0; x < 8; x++)
        {
            string s;
            cin >> s;
            drom.push_back(s);
        }

        if (lenth == 1)
            cout << "#" << tc << " " << 64 << endl;
        else
        {
            int answer(0);
            bool possible;
            for (int x = 0; x < 8; x++)
            {
                for (int y = 0; y <= 8 - lenth; y++)
                {
                    possible = true;
                    for (int z = 0; z < lenth / 2; z++)
                    {
                        if (drom[x][y + z] != drom[x][y + lenth - z - 1]) {
                            possible = false;
                            break;
                        }
                    }
                    if (possible) ++answer;
                }
            }

            for (int x = 0; x <= 8 - lenth; x++)
            {
                for (int y = 0; y < 8; y++)
                {
                    possible = true;
                    for (int z = 0; z < lenth / 2; z++)
                    {
                        if (drom[x + z][y] != drom[x + lenth - z - 1][y]){
                            possible = false;
                            break;
                        }
                    }
                    if (possible) ++answer;
                }
            }
            cout << "#" << tc << " " << answer << endl;
        }
    }
    return 0;
}