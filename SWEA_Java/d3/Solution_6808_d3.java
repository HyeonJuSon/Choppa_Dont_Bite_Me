package com.swea.d3;

import java.util.*;
import java.io.*;

public class swea_d2_6808 {
	static final int round = 9;
	static boolean[] isSelected;
	static int[] ky= new int[round];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<round;++i) ky[i] =Integer.parseInt(st.nextToken());
		
	}
//	static boolean nextinpututation() {
//		//1. ����� ã��(�ڿ�������)
//		int i=N-1;
//		while(i>0 && input[i - 1]>=input[i]) --i;
//		//2. �� �̻� ���ڸ��� ���� ���� ����
//		if(i==0) return false;
//		//3. ���ڸ� ã��
//		int j = N-1;
//		while(input[i-1]>=input[j]) --j;
//		//4. ��ȯ
//		swap(i-1,j);
//		//5. �������� ����
//		int k = N-1;
//		while(i < k) swap(i++,k--);
//		return true;
//	}
//	static void swap(int i, int j) {
//		int tmp=input[i];
//		input[i] = input[j];
//		input[j] = tmp;
//	}
}
