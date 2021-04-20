package CodeUp21to30;

import java.util.*;
import java.io.*;

public class Main_Q_27 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),".");
		int y = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		System.out.printf("%02d-%02d-%04d",d,m,y);
	}

}
