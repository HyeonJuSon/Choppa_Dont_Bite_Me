#include <iostream>
#include <string>
using namespace std;

int main()
{
    int roof;
    cin >> roof;
    string input;
    bool flag = false;
    for(int i=0;i<roof;++i){
        cin >> input;
        if(input=="anj"){
           flag = true;
        }
    }
    cout << ( flag ? "뭐야;" : "뭐야?");

    return 0;
}
