package com.algo.d2;

import java.util.*;

public class swea_2007 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= T; ++tc) {
			char[] tmp = sc.nextLine().toCharArray();
			String pattern = "";
			for (int i = 0; i < tmp.length; ++i) {
				// ù �ѱ��ڰ� ������ ���
				if (tmp[i] == tmp[i + 1] && tmp[i] == tmp[i + 2]) {
					pattern += tmp[i];
					break;
				} else { //�� ���� �̻��� ������ ��� 
					pattern += tmp[i];
					String same = "";
					for (int j = pattern.length(); j < pattern.length() * 2; ++j) {
						same += tmp[j];
					}
					if (pattern.equals(same)) 
						break;
				}
			}
			System.out.println("#" + tc + " " + pattern.length());
		}
		sc.close();
	}

}
