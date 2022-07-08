package silver;
import java.io.*;
import java.util.*;
public class BJ_25192_S4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> check = new HashSet<String>();
		int cnt = 0;
		for(int i=0;i<N;++i) {
			String now = br.readLine();
			if(now.equals("ENTER")) {
				check.clear();
			}else {
				if(!check.contains(now)) {
					check.add(now);
					++cnt;
				}
			}
		}
		System.out.println(cnt);
	}

}
