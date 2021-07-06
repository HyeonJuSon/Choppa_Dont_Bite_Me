import java.util.Arrays;

public class prg_소수찾기_LV2 {

	static int len,primeCnt, input[] ;
	static boolean[] isVisited = new boolean[10000000];//만들어진 소수 체크배열
	static boolean[] duplchk;//방문체크배열
	static public int solution(String numbers) {
        len = numbers.length();//문자열의길이
        for(int i=1;i<=len;++i) {//1, ... , 문자열의 길이만큼 뽑아보기
        	input = new int[i];//초기화
        	duplchk = new boolean[len];//초기화
        	combi(numbers,0,i);//탐색
        }
        return primeCnt;//소수개수반환
    }
	static boolean isPrime(int x) {//소수체크
		if(x<2) return false;//1이하면 소수아님
		for(int i=2;i<x;++i) {
			if(x%i==0) return false;//하나라도 나뉘면 소수아님
		}
		return true;//소수임
	}
	static void combi(String numbers,int cnt, int r) {
		if(cnt == r) {
			String str ="";
			for(int i=0;i<r;++i) {//뽑아진 인덱스로
				str += numbers.charAt(input[i]);//숫자카드를 만들어주고
			}
			int val = Integer.parseInt(str);//int형으로 바꿔서
			if(!isVisited[val] && isPrime(val)) {//체크하고
				primeCnt++;//카운팅하고
				isVisited[val]=true;//방문체크
			}
			return;//끝
		}
		for(int i=0;i<len;++i) {//인덱스뽑기
			if(duplchk[i]) continue;//중복 x
			input[cnt] = i;//뽑힌인덱스담기
			duplchk[i] = true;//방문체크
			combi(numbers,cnt+1,r);//더뽑기
			duplchk[i] = false;//방문체크해제
		}
	}
	
	public static void main(String[] args) {
		System.out.println(solution("011"));
	}

}
