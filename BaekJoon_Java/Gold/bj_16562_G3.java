package bj.gold;
import java.io.*;
import java.util.*;
public class bj_16562_G3 {
	static int[] p,val;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		for(int i=1;i<=N;++i) p[i]=i;
		val = new int[N+1];
		st= new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;++i) {
			val[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(br.readLine()," ");
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			union(v,w);
		}
		int sum =0;
		for(int i=1; i<=N; ++i) {
			if(i==p[i]) sum+=val[i];
		}
		System.out.println(sum<=K ? sum:"Oh no");
	}
	static int find(int a) {
		if(a==p[a]) return a;
		else return p[a] = find(p[a]);
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb =find(b);
		if(val[pb]>val[pa]) p[pb]=pa; //비용적은순으로
		else p[pa]=pb;
	}
}
