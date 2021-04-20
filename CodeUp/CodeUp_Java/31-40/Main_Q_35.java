package CodeUp31to40;

import java.util.*;
import java.io.*;

public class Main_Q_35 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String hex = br.readLine();
		System.out.println(Integer.toOctalString(Integer.parseInt(hex,16)));
	}

}
