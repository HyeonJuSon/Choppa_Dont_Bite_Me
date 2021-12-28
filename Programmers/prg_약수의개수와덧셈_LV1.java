
public class prg_약수의개수와덧셈_LV1 {
    static int getCount(int val){
        int cnt = 1;
        for(int i=2; i<=val; ++i) if(val%i==0)++cnt;
        return cnt;
    }
    static public int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;++i){
            int cnt = getCount(i);
            answer = cnt%2==0 ? answer + i : answer -i;
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(13,17));//43
		System.out.println(solution(24,27));//52
	}

}
