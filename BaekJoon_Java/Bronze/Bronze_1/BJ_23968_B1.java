package bronze;
import java.io.*;
import java.util.*;
public class BJ_23968_B1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//bubble sort
		int cnt = 0;
		for(int i=N-1;i>0;--i) {
			for(int j=0;j<i;++j) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j]= arr[j+1];
					arr[j+1]=tmp;
					if(++cnt == K) {
						System.out.println(arr[j]+" "+arr[j+1]);
						System.exit(0);
					}
				}
			}
		}
		System.out.println(-1);
		
	}

}
