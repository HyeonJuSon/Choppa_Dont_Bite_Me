#include<iostream>
#include<string>

using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
  
    int start(0), end(0);
    cin >> start >> end;

    int* arr = new int[end+1];
    int cnt(0);
    int boundary(1);
    int val(1);
    int answer(0);
    for (int i = 1; i < end + 1; ++i) {
        arr[i] = val;
        ++cnt;
        if (boundary == cnt) {
            cnt = 0;
            ++boundary;
            ++val;
        }
        if (start <= i && i <= end) {
            answer += arr[i];
        }
    }
    cout << answer;

    return 0;
}
