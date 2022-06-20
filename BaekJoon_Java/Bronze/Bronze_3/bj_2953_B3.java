package bronze;

import java.io.*;
import java.util.*;

public class bj_2953_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxId = -1, maxScore = 0;
		int score;
		for(int i=0;i<5;++i) {
			score = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<4;++j) score += Integer.parseInt(st.nextToken());
			if(maxScore < score ) {
				maxId = i+1;
				maxScore =score;
			}
		}
		System.out.println(maxId+" "+maxScore);
	}

}
