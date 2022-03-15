package Programmers;

import java.io.*;
import java.util.*;

public class prg_문자열압축_LV2 {

	static class Max {
		int cnt, idx;
		String base;

		Max(int cnt, int idx, String base) {
			this.cnt = cnt;
			this.idx = idx;
			this.base = base;
		}
	}

	public static int solution(String s) {
		int N = s.length();
        int answer = N;
        
        for(int len=1;len<N;++len){
            String tmp = "";
            String base="";
            int cnt=0;
            boolean isFind = false;
            for(int i=0;i<N-len;i+=len){
                cnt = 0;
                base = s.substring(i,i+len);
                isFind=false;
                System.out.println("현재 베이스 : "+base);
                for(int j=i+len;j<N-len+1;j+=len){
                    String now = s.substring(j,j+len);
                    if(base.equals(now)){
                        ++cnt;
                        isFind=true;
                    } 
                    else{
                        if(isFind) {
                            tmp += Integer.toString(cnt+1)+base;
                            i += (cnt+1)*len-1;
                        }else tmp += base;
                        break;
                    }
                    
                }
                
            }
            
            System.out.println(tmp);
            answer = Math.min(answer, tmp.length());
        }       
        return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
//		System.out.println(solution("ababcdcdababcdcd"));
//		System.out.println(solution("abcabcdede"));
//		System.out.println(solution("abcabcabcabcdededededede"));
//		System.out.println(solution("xababcdcdababcdcd"));
	}

}
