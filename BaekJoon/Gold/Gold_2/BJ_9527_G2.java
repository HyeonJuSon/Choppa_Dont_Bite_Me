import java.io.*;
import java.util.*;

public class BJ_9527_G2 {

	static long[] binary = new long[55];

	static void initBinary() {
		binary[0] = 1;
		for (int i = 1; i < 55; ++i) {
			binary[i] = 2 * binary[i - 1] + (1L << i); // 1L<<i = 2^i
		}
	}

	static long getCount(Long target) {
		long answer = target & 1;
		
		for(int i= 54; i>0 ; --i) {
			if(( target  & (1L << i)) > 0L){
				answer += binary[i-1] + (target - (1L<<i)+1);
				target -= (1L << i);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		initBinary();
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		System.out.println(getCount(B)-getCount(A-1));
	}

}
