package bronze;

import java.io.*;
import java.util.*;

public class bj_3009_B3 {

	static int x=0, y=0, pos[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		pos = new int[3][2];
		for (int i = 0; i < 3; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
		}
		if(pos[0][0] == pos[1][0]) set(2);
		else if(pos[0][0] == pos[2][0]) set(1);
		else set(0);

		for(int i=0;i<3;++i) {
			if(y!= pos[i][1]) {
				y=pos[i][1];
				break;
			}
		}
		
		System.out.println(x +" "+y);
	}
	static void set(int num) {
		x = pos[num][0];
		y = pos[num][1];
	}
}
