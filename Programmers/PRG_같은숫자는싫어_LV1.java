import java.util.*;
public class PRG_같은숫자는싫어_LV1 {

    static  int[] solution(int []arr) {
        Queue<Integer> q = new LinkedList<Integer>();
        int before = arr[0];
        q.offer(arr[0]);
        for(int i=1;i<arr.length;++i) {
        	if(before != arr[i]) {
        		q.offer(arr[i]);
        		before = arr[i];
        	}
        }
        
        int[] answer = new int[q.size()];
        int idx =0 ;
        while(!q.isEmpty()) {
        	answer[idx++] = q.poll();
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] input= {4,4,4,3,3};
		int[] output=solution(input);
		for(int a:output) System.out.print(a+" ");
	}

}
