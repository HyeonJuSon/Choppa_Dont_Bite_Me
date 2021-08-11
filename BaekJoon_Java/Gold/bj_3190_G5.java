package gold;

import java.io.*;
import java.util.*;

public class bj_3190_G5 {
	
	class Snake{
		
	}
	static class Order{
		int sec;
		char dir;
		public Order(int sec, char dir){
			this.sec=sec;
			this.dir=dir;
		}
	}
	static final int empty =0 , apple=1;
	static int N, K, L, map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;++i) {
			st = new StringTokenizer(br.readLine()," ");
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=apple;
		}
		L = Integer.parseInt(br.readLine());//방향 회전 횟수
		Queue<Order> orders = new LinkedList<>();
		for(int i=0;i<L;++i) {
			st = new StringTokenizer(br.readLine()," ");
			int sec = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			orders.offer(new Order(sec,dir));
		}
	}

}
