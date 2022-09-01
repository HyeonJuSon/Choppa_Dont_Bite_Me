package bj.silver;

import java.io.*;
import java.util.*;

public class bj_1755_S5 {
	
	static class Num implements Comparable<Num>{
		int val;
		String strVal;
		public Num(int val) {
			this.val = val;
			if(this.val >= 10) {
				strVal = parseVal(val/10)+" "+parseVal(val%10);
			}else strVal = parseVal(val);
		}
		@Override
		public int compareTo(Num o) {
			return this.strVal.compareTo(o.strVal);
		}
	}
	static String parseVal(int val) {
		String str = "";
		switch(val) {
		case 1:
			str ="one";
			break;
		case 2:
			str ="two";
			break;
		case 3:
			str ="three";
			break;
		case 4:
			str ="four";
			break;
		case 5:
			str ="five";
			break;
		case 6:
			str ="six";
			break;
		case 7:
			str ="seven";
			break;
		case 8:
			str ="eight";
			break;
		case 9:
			str ="nine";
			break;
		case 0:
			str ="zero";
			break;
		}
		return str;
	}
	static PriorityQueue<Num> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		for(int i=M; i<=N;++i) {
			pq.offer(new Num(i));
		}
		int i=0;
		while(!pq.isEmpty()) {
			System.out.print(pq.poll().val+" ");
			i++;
			if(i%10 ==0) System.out.println();
		}
	}

}
