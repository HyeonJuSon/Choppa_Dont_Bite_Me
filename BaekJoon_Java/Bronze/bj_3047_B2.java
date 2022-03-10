package bronze;
import java.io.*;
import java.util.*;
public class bj_3047_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		String idx="A";
		int arr[]=new int[3];
		for(int i=0;i<3;++i) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		String order = br.readLine();
		for(int i=0;i<order.length();++i) {
			char now = order.charAt(i);
			System.out.print(arr[now-'A']+" ");
		}
	}

}
