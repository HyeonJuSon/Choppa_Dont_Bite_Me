
public class PRG_없는숫자더하기_LV1 {
	static int solution(int[] numbers) {
        boolean[] isVisited = new boolean[10];
        for(int i=0;i<numbers.length;++i){
            isVisited[numbers[i]]=true;
        }
        int answer = 0;
        for(int i=0;i<isVisited.length;++i){
            if(!isVisited[i]) answer += i;
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,3,4,6,7,8,0}));
	}

}
