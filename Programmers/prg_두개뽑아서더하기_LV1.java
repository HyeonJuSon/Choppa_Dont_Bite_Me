package Programmers;

import java.util.*;
public class prg_두개뽑아서더하기_LV1 {
	static public int[] solution(int[] numbers) {
		int N = numbers.length;
        HashSet<Integer> hs = new HashSet<>(); 
        for(int i=0;i<N-1;++i) {
            for(int j=i+1;j<N;++j){
                hs.add(numbers[i]+numbers[j]);
            }
        }
        int idx =0;
        int[] answer = new int[hs.size()];
		for(Integer key : hs) {
			answer[idx++] = key;
		}
		Arrays.sort(answer);
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2,1,3,4,1}));
	}

}
