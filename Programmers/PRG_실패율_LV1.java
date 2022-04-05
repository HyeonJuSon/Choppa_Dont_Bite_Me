import java.util.*;
public class PRG_실패율_LV1 {
	
	static class Value implements Comparable<Value>{
        double rate;
        int idx;
        Value(double rate, int idx){
            this.rate= rate;
            this.idx=idx;
        }
        @Override
        public int compareTo(Value o){
            if(o.rate == this.rate){
                return Integer.compare(this.idx, o.idx);
            }
            return Double.compare(o.rate, this.rate);
        }
    }
    static public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // 실패율이 높은 스테이지부터 내림차순으로 스테이지 번호 반환
        int[] fail = new int[N+1];
        int[] success = new int[N+1];
        for(int i=0;i<stages.length;++i){
            int val = stages[i];
            if(val <= N)
                ++fail[val];
            else val = N;
            for(int v= 1; v<=val;++v) ++success[v];
        }
        PriorityQueue<Value> pq = new PriorityQueue<>();
        for(int i=1;i<=N;++i){
            double rate = 0.0;
            if(success[i]!=0)
                rate =(double)fail[i]/(double)success[i];  
            pq.add(new Value(rate,i));
        }
        int idx= 0;
        while(!pq.isEmpty()){
            answer[idx++] = pq.poll().idx;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int N = 5;
		int[] stages= {2, 1, 2, 6, 2, 4, 3, 3};
		int[] answer = solution(N,stages);
		for(int a  : answer ) {
			System.out.print(a+" ");
		}
	}

}
