package bronze;
import java.io.*;
import java.util.*;
public class bj_6996_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String inputA= st.nextToken();
			String inputB= st.nextToken();
			char[] A = inputA.toCharArray();
			char[] B = inputB.toCharArray();
			Arrays.sort(A);
			Arrays.sort(B);
			String outputA = new StringBuilder(new String(A)).reverse().toString();
			String outputB = new StringBuilder(new String(B)).reverse().toString();
			System.out.println(outputA.equals(outputB) ?inputA+" & "+inputB+" are anagrams." : 
				inputA+" & "+inputB+" are NOT anagrams.");
		}
	}

}
