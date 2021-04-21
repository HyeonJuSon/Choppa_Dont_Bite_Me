package CodeUp91to100;

import java.io.*;
import java.util.*;

public class Main_Q_98 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[][] map = new int[w][h];
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;++i) {
			st=  new StringTokenizer(br.readLine()," ");
			int len = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			for(int l = 0; l<len;++l) {
				if(dir == 0) map[x][y++] = 1;
				else map[x++][y]=1;
			}
		}
		for(int i=0;i<w;++i) {
			for(int j=0;j<h;++j) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}
}
