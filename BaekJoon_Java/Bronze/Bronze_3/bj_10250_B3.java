package bronze;
import java.io.*;
import java.util.*;
public class bj_10250_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int floor = N % H == 0 ? H : N % H;
			int hosoo = N % H == 0? N/H : N/H+1;
			
			System.out.println(hosoo < 10? floor+"0"+hosoo : floor+""+hosoo);
		}
	}

}
