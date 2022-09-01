package com.algo.d2;

public class swea_1285_d2 {

	public static void main(String[] args) {
		

	}

}
// C++ code
//#include<iostream>
//#include<math.h>
//#include<vector>
//
//int main(int argc, char** argv)
//{
//	int T(0), N(0), Val(0), Dist(0);
//	const int iJumsu(100001);
//	std::cin >> T;
//	
//
//	for (int tc = 1; tc <= T; ++tc) {
//        std::vector<int> jumsu(iJumsu,0);
//		std::cin >> N;
//		for (int i = 0; i < N; ++i) {
//			std::cin >> Val;
//			if (Val < 0) Val *= -1;
//
//			Dist = abs(Val - 0);
//			jumsu[Dist]++;
//		}
//
//		for (int i = 0; i < iJumsu; ++i) {
//			if (jumsu[i] > 0) {
//				std::cout << "#" << tc << " " << i << " " << jumsu[i] << '\n';
//				break;
//			}
//		}
//	}
//	return 0;
//}