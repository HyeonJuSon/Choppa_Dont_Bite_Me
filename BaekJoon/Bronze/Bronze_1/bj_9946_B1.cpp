#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(void){
	string before, after;
	int idx = 1;
	while(true){
		cin >> before >> after;	
		if(before=="END" && after =="END")break;
		sort(before.begin(), before.end());
		sort(after.begin(),after.end());
		cout << "Case " << idx++ << ": " << (before == after ? "same":"different")<<endl;
	}
	
	
	
	return 0;	
}
