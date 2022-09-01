package gold;
import java.io.*;
import java.util.*;
public class bj_11571_G5 {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int div = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int[] mod = new int[100000];
			Arrays.fill(mod, -1);
			int start =0, end=0,idx=0;
			int tmp = div;
			while(true) {
				tmp = tmp % N * 10;
				if(mod[tmp]!=-1) {
					start = mod[tmp];
					end = idx;
					break;
				}
				mod[tmp]=idx++; 
			}
			sb.append(div/N).append(".");
			tmp = div % N * 10;
			for(int i=0;i<start;++i) {
				sb.append(tmp/N);
				tmp = tmp%N*10;
			}
			sb.append("(");
			for(int i=start;i<end;++i) {
				sb.append(tmp/N);
				tmp = tmp %N *10;
			}
			sb.append(")").append('\n');
		}
		System.out.println(sb.toString());
	}

}
