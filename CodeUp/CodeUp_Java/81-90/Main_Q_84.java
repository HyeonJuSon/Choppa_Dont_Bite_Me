package CodeUp81to90;

import java.util.*;
import java.io.*;
public class Main_Q_84 {
	static int max,total =0,r,g,b, input[] = new int[3];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		r = Integer.parseInt(st.nextToken());
		 g = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		max = Integer.max(r, Integer.max(g,b));
		combi(0);
		bw.write(Integer.toString(total));
		bw.flush();
		bw.close();
	}
	
	static void combi(int cnt) throws IOException {
		if(cnt == 3) {
			if(input[0] >= r || input[1] >= g || input[2] >= b) return;
			bw.write(input[0]+" "+input[1]+" "+input[2]+'\n');
			total++;
			return;
		}
		
		for(int i=0;i<max;++i) {
			input[cnt] = i;
			combi(cnt+1);
		}
	}
}
