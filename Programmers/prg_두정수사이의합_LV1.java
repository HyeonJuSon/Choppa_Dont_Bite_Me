package Programmers;

public class prg_두정수사이의합_LV1 {
	static public long solution(int a, int b) {
        long answer = 0;
        if(a > b){
            int tmp = a;
            a= b;
            b=tmp;
        }
        for(int i=a;i<=b;++i){
            answer += i;
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(3,5));//12
		System.out.println(solution(3,3));//3
	}

}
