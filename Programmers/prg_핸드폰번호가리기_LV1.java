package Programmers;

public class prg_핸드폰번호가리기_LV1 {
	static public String solution(String phone_number) {
        int N = phone_number.length();
        String answer = "";
        for(int i=0;i<N-4;++i) answer +="*";
        answer+=phone_number.substring(N-4,N);
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution("01033334444"));
	}

}
