import java.io.*;
import java.util.*;
public class bj_1806_G4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int start = 0, end = 0, sum = 0 ,min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;++i) arr[i] = Integer.parseInt(st.nextToken());
		while(true) {
			if(sum >= S) {
				sum -= arr[start];//부분합이 S보다 클경우start가 가리키는원소를뺴고 start위치증가
				min  = Math.min(min, end-start++);//길이 갱신
			}else if(end == N) {//end가 마지막 위치라면 끝낸다.
				break;
			}else {
				sum += arr[end++];//위의 경우가 아니면 end증가시켜서 합쳐줌
			}
		}
		System.out.println(min==Integer.MAX_VALUE?0:min);
	}

}
