import java.io.*;
import java.util.*;
public class BJ_3029_B3 {

	static final int H=0, M=1, S=2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(),":");
		int[] now = new int[3];
		for(int i=0;i<3;++i) now[i]=Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine(),":");
		int[] target = new int[3];
		for(int i=0;i<3;++i) target[i]=Integer.parseInt(st.nextToken());
		int HH = target[H]-now[H];
		int MM = target[M]-now[M];
		int SS = target[S]-now[S];
		if(SS<0) {
			SS+=60;
			--MM;
		}
		if(MM<0) {
			MM+=60;
			--HH;
		}
		if(HH<0) {
			HH+=24;
		}
		if(HH==0&&MM==0&&SS==0) System.out.println("24:00:00");
		else System.out.printf("%02d:%02d:%02d\n", HH,MM,SS);
	}

}
