package bronze;
import java.util.*;
import java.io.*;
public class bj_9085_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int i=0;i<TC;++i) {
			int N = Integer.parseInt(br.readLine());
			int sum =0;
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;++j) sum+= Integer.parseInt(st.nextToken());
			System.out.println(sum);
		}
	}

}
