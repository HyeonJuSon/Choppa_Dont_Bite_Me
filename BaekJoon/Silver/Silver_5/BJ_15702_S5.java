package silver;
import java.io.*;
import java.util.*;
public class BJ_15702_S5 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] score =new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;++i) score[i]=Integer.parseInt(st.nextToken());
		PriorityQueue<Student> answer = new PriorityQueue<>();
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(br.readLine()," ");
			int idx = Integer.parseInt(st.nextToken());
			int sum = 0;
			for(int j=0;j<N;++j) {
				String now = st.nextToken();
				if(now.equals("O")){
					sum += score[j];
				}
			}
			answer.add(new Student(idx,sum));
		}
		
		System.out.println(answer.peek().idx+" "+answer.peek().score);
	}
	static class Student implements Comparable<Student>{
		int idx, score;

		public Student(int idx, int score) {
			this.idx = idx;
			this.score = score;
		}

		@Override
		public int compareTo(Student o) {
			if(o.score==this.score) {
				return Integer.compare(this.idx, o.idx);
			}
			return Integer.compare(o.score, this.score);
		}
		
		
	}
}
