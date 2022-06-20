package bronze;

import java.io.*;
import java.util.*;

public class bj_11023_B3 {

	public static void main(String[] args) throws Exception{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine()," ");
	        int sum = 0;
	        while(st.hasMoreTokens()) {
	        	sum += Integer.parseInt(st.nextToken());
	        }
	        System.out.println(sum);
		}
	

}
