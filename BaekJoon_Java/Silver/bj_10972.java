package BJ;
import java.util.*;
import java.io.*;
public class bj_10972 {
	static int N;		//���� N
	static int[] input; // �Է� �� -> �Է� ���� ������ ���� ���� ã�ƾ���
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());//������ �Է¹޴´�.
		input = new int[N];//�Է� �迭 �Ҵ�
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;++i) input[i] =Integer.parseInt(st.nextToken());
		if(nextinpututation()) {
			for(int i : input)
				sb.append(i).append(" ");
		}else sb.append("-1");
		System.out.println(sb);
	}
	static boolean nextinpututation() {
		//1. ����� ã��(�ڿ�������)
		int i=N-1;
		while(i>0 && input[i - 1]>=input[i]) --i;
		//2. �� �̻� ���ڸ��� ���� ���� ����
		if(i==0) return false;
		//3. ���ڸ� ã��
		int j = N-1;
		while(input[i-1]>=input[j]) --j;
		//4. ��ȯ
		swap(i-1,j);
		//5. �������� ����
		int k = N-1;
		while(i < k) swap(i++,k--);
		return true;
	}
	static void swap(int i, int j) {
		int tmp=input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
}
