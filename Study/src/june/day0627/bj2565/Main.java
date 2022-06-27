package june.day0627.bj2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dp, power;	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		dp = new int[101];	
		power = new int[501];	
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			power[a] = b;
		}
		
		int count = 0;
		int dpLen = 1;
		for(int i = 1; i < power.length; i++) {
			if(power[i] != 0) {	
				if(dp[dpLen - 1] < power[i]) {	
					dp[dpLen++] = power[i];
				}
				else {	
					binarySearch(dpLen, i);
				}
			}
		}
		
		System.out.println(n - dpLen + 1);
	}
	
	public static void binarySearch(int dpLen, int nowIndex) {
		int start = 0;
		int end = dpLen;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int midDpEle = dp[mid];
			
			if(midDpEle < power[nowIndex]) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		dp[start] = power[nowIndex];
	}
}