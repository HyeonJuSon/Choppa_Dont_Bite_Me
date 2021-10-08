#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string get_grade(float avg){
    if(avg >= 90.0) return "A";
    else if(avg >= 80.0) return "B";
    else if(avg >= 70.0) return "C";
    else if(avg >= 50.0) return "D";
    else return "F";
}

string solution(vector<vector<int>> scores) {
    string answer = "";
    const int length = scores[0].size();
    for(int j=0;j<length;++j){
        int sum(0), cnt(0), pass(0);
        int min_val(100), max_val(0);
        float avg(0.0);
        for(int i=0;i<length;++i){
            if(i==j){
                pass = scores[i][j];
            }else {
                ++cnt;
                sum += scores[i][j];
                min_val = min(min_val, scores[i][j]);
                max_val = max(max_val, scores[i][j]);
            }
        }
        if(min_val<=pass && pass <= max_val) {
            sum += pass;
            ++cnt;
        }
        avg = sum / cnt;
        answer+= get_grade(avg);
    }
    
    return answer;
}