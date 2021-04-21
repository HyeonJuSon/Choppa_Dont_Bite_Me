package CodeUp81to90;

import java.util.*;
import java.io.*;
public class Main_Q_81 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i=1; i<=n;++i) {
			for(int j=1;j<=m;++j) {
				System.out.println(i+ " "+j);
			}
		}
	}
}
