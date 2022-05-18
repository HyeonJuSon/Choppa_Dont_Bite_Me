package gold;

public class PRG_124나라의숫자_LV2 {
	 static public String solution(int n) {
	        String answer = "";
	        String[] arr = {"4","1","2"};
	        while(true){
	            int module = n%3;
	            n/=3;
	            if(module==0) --n;
	            if(n<0) break;
	            answer= arr[module] +answer;
	        }
	        return answer;
	    }
	public static void main(String[] args) {
		System.out.println(solution(1)); // 1
		System.out.println(solution(2)); // 2
		System.out.println(solution(3)); // 4
		System.out.println(solution(4)); // 11
		
	}

}
