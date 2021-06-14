import java.util.*;
public class prg_완주하지못한선수_l1 {
	
	static String Solution(String[] participant, String[] completion) {
		 	Arrays.sort(participant);
			Arrays.sort(completion);
	      
			for(int i=0;i<completion.length;++i) {
				if(!participant[i].equals(completion[i])) {
					return participant[i];
				}
			}
	        return participant[participant.length-1];
	}
	
	public static void main(String[] args) throws Exception {
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};

		System.out.println(Solution(participant,completion));
	}

}
