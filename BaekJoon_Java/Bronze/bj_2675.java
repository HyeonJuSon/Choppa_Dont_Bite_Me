package bj;
import java.io.*;
import java.util.*;
public class bj_2675 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int T = Int(br.readLine());
		for(int tc=1; tc<=T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Int(st.nextToken());
			char[] S = st.nextToken().toCharArray();
			
			for(int i=0; i<S.length;++i) {
				for(int j=0; j<N; ++j) {
					System.out.print(S[i]);
				}
			}
			System.out.println();
		}
	}
	
	static int Int(String s) {
		return Integer.parseInt(s);
	}
}
