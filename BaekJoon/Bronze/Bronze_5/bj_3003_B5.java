package bronze;
import java.io.*;
import java.util.*;
public class bj_3003_B5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] chess = {1,1,2,2,2,8};
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int val = Integer.parseInt(st.nextToken());
		sb.append(chess[0]-val);
		for(int i=1;i<6;++i) {
			val = Integer.parseInt(st.nextToken());
			sb.append(" ").append(chess[i]-val);
		}
		System.out.println(sb.toString());
	}

}
