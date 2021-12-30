package bronze;
import java.util.*;
import java.io.*;

public class bj_15726_B4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		double A = Integer.parseInt(st.nextToken());
		double B = Integer.parseInt(st.nextToken());
		double C = Integer.parseInt(st.nextToken());
		System.out.println(Math.max((int)(A*B/C), (int)(A/B*C)));
	}

}
