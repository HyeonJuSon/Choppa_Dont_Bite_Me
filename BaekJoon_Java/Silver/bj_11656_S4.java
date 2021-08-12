package silver;
import java.io.*;
import java.util.*;
public class bj_11656_S4 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String target = br.readLine();
		int len = target.length();
		PriorityQueue<String> answer = new PriorityQueue<String>();
		for(int i=0;i<len;++i)
			answer.add(target.substring(i));
		while(!answer.isEmpty()) System.out.println(answer.poll());
	}

}
