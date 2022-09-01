#include<iostream>
#include<algorithm>
using namespace std;

int main(void){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int arr[5], sum(0);
  for (int i = 0; i < 5;++i){
    cin >> arr[i];
    sum += arr[i];
  }
  sort(arr, arr+5);
  cout << sum / 5 << '\n'
       << arr[2];
  return 0;
}