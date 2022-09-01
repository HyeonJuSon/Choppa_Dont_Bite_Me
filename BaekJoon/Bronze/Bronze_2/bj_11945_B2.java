package bronze;
import java.io.*;
import java.util.*;
public class bj_11945_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0;i<N;++i) {
			String now = br.readLine();
			int idx = 0;
			for(int j=M-1;j>=0;--j) {
				map[i][j]=Integer.parseInt(now.charAt(idx++)+"");
			}
		}
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
