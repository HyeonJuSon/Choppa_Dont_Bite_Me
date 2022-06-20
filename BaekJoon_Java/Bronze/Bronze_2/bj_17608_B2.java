package bronze;
import java.util.*;
public class bj_17608_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		int[] arr= new int[N];
		for(int i=0;i<N;++i) arr[i] = sc.nextInt();
		int right = arr[N-1];
		int cnt = 1;
		for(int i=N-2;i>=0;--i) {
			if(right < arr[i]) {
				right = arr[i];
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
