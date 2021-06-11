package bronze;
import java.io.*;
import java.util.*;
public class bj_1924_B1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		System.out.println(getDay(X,Y));
	}
	
	static String getDay(int x, int y) {
		for(int i=1;i<x;++i) {
			if(i==2) y+=28;
			else if(i==4 || i==6||i==9||i==11) y+=30;
			else y+=31;
		}
		return getAnswer(y%7);
	}

	static String getAnswer(int val) {
		switch(val) {
			case 1:
				return "MON";
			case 2:
				return "TUE";
			case 3:
				return "WED";
			case 4:
				return "THU";
			case 5:
				return "FRI";
			case 6:
				return "SAT";
			case 0:
				return "SUN";
		}
		return "";
	}
}
