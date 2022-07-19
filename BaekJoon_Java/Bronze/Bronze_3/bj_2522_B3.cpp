#include <iostream>

using namespace std;

int main()
{
    int n ;
    cin >> n;
    int empty = n-1;
    bool isDecrease = true;
    for(int i=0; i<2*n; ++i){
        for(int e=0;e<empty;++e) cout << " ";
        for(int s=0;s<n-empty;++s) cout <<"*";
        cout <<'\n';
        if(i==n-1) isDecrease = false;
        if(isDecrease) empty--;
        else empty++;
    }
    return 0;
}