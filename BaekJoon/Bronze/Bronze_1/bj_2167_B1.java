package bronze;
import java.io.*;
import java.util.*;
public class bj_2167_B1 {

	public static void main(String[] args) throws Exception  {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int loop = Integer.parseInt(br.readLine());
		for(int l=0;l<loop;++l) {
			int sum = 0;
			st= new StringTokenizer(br.readLine()," ");
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			for(int a=i;a<=x;++a) {
				for(int b=j;b<=y;++b) {
					sum+=arr[a][b];
				}
			}
			System.out.println(sum);
		}
	}

}
