package CodeUp11to20;

import java.io.*;
import java.util.*;

public class Main_Q_19 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),".");
		int[] ymd = new int[3];
		for(int i=0;i<ymd.length;++i)
			ymd[i]=Integer.parseInt(st.nextToken());
		System.out.printf("%04d.%02d.%02d",ymd[0],ymd[1],ymd[2]);
	}

}