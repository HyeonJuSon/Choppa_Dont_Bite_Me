package bronze;

import java.io.*;
import java.util.*;

public class bj_17256_B5 {

	public static class cake {
		int x, y, z;

		cake(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		cake A = new cake(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine(), " ");
		cake C = new cake(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		System.out.println((C.x - A.z) + " " + (C.y / A.y) + " " + (C.z - A.x));
	}

}
