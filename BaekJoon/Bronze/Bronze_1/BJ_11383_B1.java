package bronze;
import java.io.*;
import java.util.*;
public class BJ_11383_B1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<String> A= new LinkedList<>();
		Queue<String> B= new LinkedList<>();
		for(int i=0;i<N;++i) A.offer(br.readLine());
		for(int i=0;i<N;++i) B.offer(br.readLine());
		boolean isPossible = true;
		while(!A.isEmpty()) {
			String now = A.poll();
			String output = "";
			for(int i=0;i<now.length();++i) {
				for(int j=0;j<2;++j)
					output+=now.charAt(i);
			}
			if(!output.equals(B.poll())) {
				isPossible=false;
				break;
			}
		}
		System.out.println(isPossible ? "Eyfa" : "Not Eyfa");
		
	}

}
