#include <iostream>

using namespace std;

int main()
{
    int T(0);
    cin >> T;
    for(int tc = 0; tc < T; ++tc){
        int val(0);
        cin >> val;
        char arr[val][val];
        for(int i=0;i<val;++i){
            for(int j=0;j<val;++j){
                arr[i][j] = 'J';
                if(i==0 || i==val-1 || j==0 ||j==val-1) arr[i][j]='#';
                cout << arr[i][j];
            }
            cout << endl;
        }
        cout << endl;
    }
    return 0;
}
