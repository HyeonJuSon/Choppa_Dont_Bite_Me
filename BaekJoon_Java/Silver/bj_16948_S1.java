package silver;
import java.io.*;
import java.util.*;
public class bj_16948_S1 {
	static int[][] dir = {{-2,-2,0,0,2,2},{-1,1,-2,2,-1,1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] start = new int[2];
		int[] end = new int[2];
		start[0] = Integer.parseInt(st.nextToken());
		start[1] = Integer.parseInt(st.nextToken());
		end[0] = Integer.parseInt(st.nextToken());
		end[1] = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q= new LinkedList<>();
		boolean isVisited[][] = new boolean[N][N];
		q.offer(start);
		isVisited[start[0]][start[1]] = true;
		
		boolean find = false;
		int[][] dist = new int[N][N];
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(now[0] == end[0] && now[1] == end[1]) {
				find=true;
				break;
			}
			for(int d=0; d<6;++d) {
				int nx = now[0]+dir[0][d];
				int ny = now[1]+dir[1][d];
				if(0<=nx && nx<N && 0<=ny && ny<N && !isVisited[nx][ny]) {
					isVisited[nx][ny] = true;
					dist[nx][ny] = dist[now[0]][now[1]]+1;
					q.offer(new int[]{nx,ny});
				}
			}
		}
		System.out.println(find==true?dist[end[0]][end[1]]:-1);
	}
}
