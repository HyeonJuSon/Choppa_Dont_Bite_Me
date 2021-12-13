package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_3058_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; ++i) {
			int sum =0;
			int min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<7;++j) {
				int val  =Integer.parseInt(st.nextToken());
				if(val%2==0) { sum+=val;
				min = Math.min(min, val);
				}
			}
			System.out.println(sum+" "+min);
			
		}
	}

}
