package bronze;
import java.util.*;
import java.io.*;
public class bj_10824_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		String A =st.nextToken();
		String B =st.nextToken();
		String C =st.nextToken();
		String D =st.nextToken();
		System.out.println(Long.parseLong(A+B)+Long.parseLong(C+D));
	}

}
