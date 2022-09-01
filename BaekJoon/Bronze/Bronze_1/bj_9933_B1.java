package bronze;
import java.io.*;
import java.util.*;
public class bj_9933_B1 {

	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		String find ="";
		for(int i=0;i<N;++i) {
			StringBuilder sb = new StringBuilder();
			String now = br.readLine();
			sb.append(now);
			hm.put(now, 1);
			if(hm.containsKey(sb.reverse().toString())) {
				find = now;
				break;
			}
		}
		System.out.println(find.length()+" "+find.charAt(find.length()/2));
	}

}
