package silver;

import java.io.*;
import java.util.*;

public class bj_9095_S3 {
	static int target,cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; ++n) {
			target = Integer.parseInt(br.readLine());
			cnt =0 ;
			find(0);
			System.out.println(cnt);
		}
	}
	static void find( int sum) {
		if(sum==target) {
			cnt++;
			return;
		}
		
		for(int i=1;i<=3;++i) {
			if(sum+i <=target) {
				find(sum+i);
			}
		}
	}
}
