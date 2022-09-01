package gold;
import java.io.*;
import java.util.*;
public class bj_2617_G5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] heavy = new int[N][N];
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(br.readLine()," ");
			int h =Integer.parseInt(st.nextToken())-1;
			int l =Integer.parseInt(st.nextToken())-1;
			heavy[h][l]=1;
			heavy[l][h]=-1;
		}
		
		for(int k=0;k<N;++k) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(i==j||i==k||j==k)continue;
					if(heavy[i][k]==1&&heavy[k][j]==1) heavy[i][j]=1;
					if(heavy[i][k]==-1&&heavy[k][j]==-1) heavy[i][j]=-1;
				}
			}
		}
		int target = (N+1)/2;
		int answer=  0;
		for(int i=0;i<N;++i) {
			int cntH = 0;
			int cntL = 0;
			for(int j=0;j<N;++j) {
				if(heavy[i][j]==1) ++cntH;
				if(heavy[i][j]==-1) ++cntL;
			}
			if(cntH>=target || cntL >=target) ++answer;
		}
		System.out.println(answer);
	}

}
