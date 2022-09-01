package gold;
// memmory 초과
import java.io.*;
import java.util.*;

public class bj_9527_G2 {

	public static class Binary implements Comparable<Binary>{
		String val;
		Binary(String val){
			this.val=val;
		}
		@Override
		public int compareTo(Binary o) {
			return	Integer.compare(o.val.length(), this.val.length());
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		PriorityQueue<Binary> pq= new PriorityQueue<>();
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		for(long i=A; i<=B;++i) {
			pq.add(new Binary(Long.toBinaryString(i)));
		}
		int sum =0;
		int max = pq.peek().val.length();
		int arr[] =new int[max];
		while(!pq.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			Binary now = pq.poll();
			int N = now.val.length();
			char[] tmp = sb.append(now.val).reverse().toString().toCharArray();
			for(int i=0;i<N;++i) {
				arr[i]+= tmp[i]-'0';
			}
		}
		for(int i=0;i<max;++i) if(arr[i]>0) sum+=arr[i];
		System.out.println(sum);
	}

}
