package bronze;
import java.io.*;
import java.util.*;
public class BJ_14489_B4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		int chicken = Integer.parseInt(br.readLine())*2;
		System.out.println(sum >= chicken ? sum - chicken : sum);
		
	}

}
