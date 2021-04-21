package CodeUp91to100;

import java.io.*;
import java.util.*;

public class Main_Q_97 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[19][19];
		for(int i=0;i<19;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<19;++j) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x=Integer.parseInt(st.nextToken())-1;
			int y= Integer.parseInt(st.nextToken())-1;
			for(int xx=0;xx<19;++xx) {
				map[xx][y] = map[xx][y] == 0? 1: 0;
			}
			for(int yy=0;yy<19;++yy) {
				map[x][yy] = map[x][yy] == 0? 1: 0;
			}
		}
		for(int i=0;i<19;++i) {
			for(int j=0;j<19;++j) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}
}
