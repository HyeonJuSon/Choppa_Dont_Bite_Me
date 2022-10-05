import java.io.*;
import java.util.*;
public class BJ_11586_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		for(int i=0;i<N;++i) {
			map[i] = br.readLine().toCharArray();
		}
		int order = Integer.parseInt(br.readLine());
		if(order == 1) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}else if(order == 2) {
			for(int i=0;i<N;++i) {
				for(int j=N-1;j>=0;--j) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}else {
			for(int i=N-1;i>=0;--i) {
				for(int j=0;j<N;++j) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

}
