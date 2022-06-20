package bronze;
import java.io.*;
import java.util.*;
public class bj_13985_B4 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		String o1 = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		String o2 = st.nextToken();
		int c = Integer.parseInt(st.nextToken());
		if(o1.equals("+")&&o2.equals("=")) {
			System.out.println(a+b==c ? "YES":"NO");
		}
	}

}
