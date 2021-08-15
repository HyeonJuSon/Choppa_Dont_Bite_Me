package bronze;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_5576_B2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		PriorityQueue<Integer> W = new PriorityQueue<Integer>(Collections.reverseOrder());//W대학
		PriorityQueue<Integer> K = new PriorityQueue<Integer>(Collections.reverseOrder());//W대학
		for(int i=0;i<10;++i) W.add(sc.nextInt());
		for(int i=0;i<10;++i) K.add(sc.nextInt());
		int wSum =0 , kSum = 0;
		for(int i=0;i<3;++i) {
			wSum += W.poll();
			kSum += K.poll();
		}
		System.out.println(wSum+" "+kSum);
	}

}
