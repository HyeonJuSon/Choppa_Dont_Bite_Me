package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_17225 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// �����, ������, �մԼ�, ���Žð�, ���Ż���, ��������
		int A, B, N, time, color, cnt;
		// ����� ��, ���� �� ����Ʈ
		LinkedList<int[]> workA = new LinkedList<>();
		LinkedList<int[]> workB = new LinkedList<>();
		// ���� ť 
		LinkedList<Integer> presents = new LinkedList<>();
		
		// A,B,N�Է�
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		// �մ� �� ��ŭ �Է��� �ݺ�
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; ++i) {
			time = Integer.parseInt(st.nextToken());
			color = st.nextToken() == "B" ? 1 : 2;
			cnt = Integer.parseInt(st.nextToken());
			
		}
	}

}
