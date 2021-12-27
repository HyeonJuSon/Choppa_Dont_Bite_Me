
public class prg_소수만들기_LV1 {
	static int N, answer = 0 ;
    static int[] primes = new int[2998];
    static public int solution(int[] nums) {
        N = nums.length;
        for(int i=2;i<2998;++i) primes[i]=i;
        for(int i=2;i<2998;++i){
            if(primes[i]==0)continue;
            for(int j= i+i; j < 2998; j+=i) primes[j] = 0;
        }
        comb(0,0,new boolean[N], 0, nums);
        return answer;
    }
    static void comb(int start,int cnt, boolean[] isVisited, int sum, int[] nums){
        if(cnt == 3){
            if(primes[sum]!=0)
                ++answer;
            return;
        }
        for(int i=start;i<N;++i){
            if(isVisited[i]) continue;
            isVisited[i]=true;
            comb(i+1,cnt+1, isVisited, sum + nums[i],nums);
            isVisited[i]=false;
        }
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,3,4}));
	}

}
