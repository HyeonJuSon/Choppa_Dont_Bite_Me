	package bronze;
	
	import java.util.Scanner;
	
	public class bj_5893_B4 {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String bin = sc.next();
			Long dec = Long.parseLong(bin, 2);
			dec *= 17;
			System.out.println(Long.toBinaryString(dec));
		}
	
	}
