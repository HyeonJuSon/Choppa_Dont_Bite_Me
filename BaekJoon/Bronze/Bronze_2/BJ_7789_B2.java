package bronze;
import java.io.*;
import java.util.*;
public class BJ_7789_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		String original = st.nextToken();
		String refresh = st.nextToken() + original;
		int A = Integer.parseInt(original);
		int B = Integer.parseInt(refresh);
		
		boolean isPrime = true;
		
		for(int i=2;i<A/2;++i) {
			if(A % i == 0) {
				isPrime = false;
				break;
			}
		}
		
		if(isPrime) {
			for(int i=2;i<B/2;++i) {
				if(B%i==0) {
					isPrime=false;
					break;
				}
			}
		}
		
		System.out.println(isPrime ? "Yes" : "No");
	}

}
