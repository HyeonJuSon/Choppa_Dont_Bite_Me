package bronze;
import java.io.*;
public class bj_11721_b2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(int i=0;i<str.length();++i){
        	if(i>9 && i%10 == 0) System.out.println();
            System.out.print(str.charAt(i));
        }

	}

}
