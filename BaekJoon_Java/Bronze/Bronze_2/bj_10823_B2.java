package day;

import java.io.*;
import java.util.*;

public class bj_10823_B2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int sum =0;
		while(true) {
			String tmp=br.readLine();
			if(tmp==null) break;
			for(int i=0;i<tmp.length();++i) {
				if(tmp.charAt(i)==',') {
					sum+=Integer.parseInt(sb.toString());
					sb = new StringBuilder();
				}else sb.append(tmp.charAt(i));
			}
		}
		sum+=Integer.parseInt(sb.toString());
		System.out.println(sum);
	}

}
