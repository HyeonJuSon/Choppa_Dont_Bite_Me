#include <iostream>
#include <regex>
#include <string>
using namespace std;
int main() {
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    string input("");
    cin >> input;
    int arr[26]={0};
    for(int i=0;i<input.length();++i){
        char now = input.at(i);
        arr[now-'A']++;
    }
    regex rg;
    string change;
    if(arr[0]>=1){
        rg = "[BCDF]";
        change ="A";
    }else if(arr[1]>=1) {
        rg = "[CDF]";
        change ="B";
    }else if(arr[2]>=1){
        rg="[DF]";
        change ="C";
    }else{
        rg="[A-Z]";
        change ="A";
    }
    input = regex_replace(input, rg,change);
    cout << input;
}
