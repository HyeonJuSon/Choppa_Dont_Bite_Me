package bronze;
import java.io.*;
import java.util.*;
public class BJ_9295_B3 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int sum = 0;
			sum += Integer.parseInt(st.nextToken());
			sum += Integer.parseInt(st.nextToken());
			System.out.println("Case "+t+": "+sum);
		}
	}

}
