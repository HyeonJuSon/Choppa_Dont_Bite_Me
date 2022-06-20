package bronze;
import java.io.*;
public class bj_14581_B3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		for(int i=0;i<3;++i) {
			for(int j=0;j<3;++j) {
				if(i==1&&j==1) {
					System.out.print(":"+input+":");
				}else System.out.print(":fan:");
			}
			System.out.println();
		}
	}

}
