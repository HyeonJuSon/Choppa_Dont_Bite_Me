package bronze;

import java.util.Scanner;

public class bj_1032_B1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		String answer ="";
		for(int i=0;i<N;++i) arr[i] = sc.next();
		for(int i=0;i<arr[0].length();++i) {
			char before = ' ';
			boolean flag = true;
			for(int j=0;j<N;++j) { // 행
				if(before==' ') {
					before=arr[j].charAt(i);
				}else {
					if(before!=arr[j].charAt(i)) {
						flag =false;
						break;
					}
				}
			}
			if(flag) answer+=before;
			else answer+="?";
		}
		System.out.println(answer);
	}

}
