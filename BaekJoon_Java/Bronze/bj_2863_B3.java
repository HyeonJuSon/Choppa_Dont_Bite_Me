package bronze;
import java.io.*;
import java.util.*;
public class bj_2863_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[][]=new int[2][2];
		for(int i=0;i<2;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<2;++j) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		double maxVal = 0;
		int maxCnt = -1;
		double val[] = new double[4];
		double A=arr[0][0], B=arr[0][1], C=arr[1][0], D=arr[1][1];
		val[0] = (A/C)+(B/D);
		val[1] = (C/D)+(A/B);
		val[2] = (D/B)+(C/A);
		val[3] = (B/A)+(D/C);
		for(int i=0;i<4;++i) {
			if(maxVal < val[i]) {
				maxVal=val[i];
				maxCnt=i;
			}
		}
		System.out.println(maxCnt);
	}

}
