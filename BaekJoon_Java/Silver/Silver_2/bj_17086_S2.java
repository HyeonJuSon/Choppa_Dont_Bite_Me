package gold;
import java.io.*;
import java.util.*;
public class bj_17086_S2 {
	static int[][] dir = {{-1,-1,-1,0,0,1,1,1},{-1,0,1,-1,1,-1,0,1}};
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] dist = new int[N][M];
		Queue<int[]> sharks = new LinkedList<>();
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;++j) {
				int val = Integer.parseInt(st.nextToken());
				if(val == 1) {
					sharks.add(new int[] {i,j});
					dist[i][j]=0;
				}else dist[i][j]=999;
				map[i][j] = val;
			}
		}
		
		while(!sharks.isEmpty()) {
			Queue<int[]> bfs = new LinkedList<>();
			bfs.add(sharks.poll());
			boolean[][] isVisited =new boolean[N][M];
			while(!bfs.isEmpty()) {
				int[] now = bfs.poll();
				for(int d=0;d<8;++d) {
					int nx = now[0]+dir[0][d];
					int ny = now[1]+dir[1][d];
					if(isBoundary(nx,ny) && map[nx][ny]==0 && !isVisited[nx][ny]) {
						isVisited[nx][ny]=true;
						if(dist[now[0]][now[1]]+1 < dist[nx][ny]) {
							dist[nx][ny]=dist[now[0]][now[1]]+1;
							bfs.add(new int[] {nx,ny});
						}
					}
				}
			}
		}
		int Max = 0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				Max = Math.max(Max, dist[i][j]);
			}
		}
		System.out.println(Max);
	}
	
	static boolean isBoundary(int x, int y) {
		return 0 <= x && x< N  && 0<=y &&y<M;
	}
}

/*
 �� ĭ���� �Ʊ� �� �ִ� 1���� ����
 � ĭ�� ���� �Ÿ��� �� ĭ�� ���� �Ÿ��� ����� �Ʊ� ������ �Ÿ�
 �̵��� ������ 8����(�밢�� ����)
 ���� �Ÿ��� ���� ū ĭ
*/