package july.day0714.bj2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int res1 = 0, res2 = 0;
		int start = 0;
		int end = N-1;
		int min = Integer.MAX_VALUE;
		while(start < end) {
			int sum = arr[start] + arr[end];
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				res1 = arr[start];
				res2 = arr[end];
				if(sum == 0) break;
			}
			if(sum < 0) {
				start += 1;
			}else {
				end -= 1;
			}
		}
		System.out.println(res1+" "+res2);
	}
}
