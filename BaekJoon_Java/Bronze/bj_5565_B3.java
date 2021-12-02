package bronze;

import java.io.*;
import java.util.*;

public class bj_5565_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Total = Integer.parseInt(br.readLine());
		int Sum = 0;
		for(int i=0;i<9;++i) Sum += Integer.parseInt(br.readLine());
		System.out.println(Total - Sum);
	}

}
