package algotest.day0703.grade;

public class solution {
	class Solution {
	    public int solution(int[] grade) {
	    	
	    	int result = 0;
	    	for (int i = grade.length-1; i > 0; i++) {
				if(grade[i]<grade[i-1]) {
					result += grade[i-1]-grade[i];
					grade[i-1] = grade[i];
				}
			}
	    	
	        int answer = result;
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] arr = {3,2,3,6,4,5};
		System.out.println(solution(arr));
	}
	private static int solution(int[] grade) {
		
		int result = 0;
    	for (int i = grade.length-1; i > 0; i--) {
			if(grade[i]<grade[i-1]) {
				result += grade[i-1]-grade[i];
				grade[i-1] = grade[i];
			}
		}
    	
        int answer = result;
        return answer;
	}
}
