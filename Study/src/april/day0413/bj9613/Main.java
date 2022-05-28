package april.day0413.bj9613;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int t = sc.nextInt();
		for(int tc = 0; tc<t;tc++) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			long answer = 0;
			for(int i = 0; i<n ;i++) {
				nums[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					answer += gcd(nums[i],nums[j]);
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	public static int gcd(int a, int b) {
			
			if(b>a) {
				int temp = a;
				a = b;
				b = temp;
			}
			
			while(b>0) {
				int r = a % b;
				a = b;
				b = r;
			}
			
			return a;
		}
	}
