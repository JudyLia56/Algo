package may.day0521.bj3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		int X = Integer.parseInt(br.readLine());
		int cnt = 0;
		int start = 0;
		int end = N-1;
		int sum = 0;
		
		while(start < end) {
			sum = num[start]+num[end];
			if(sum == X) cnt++;
			if(sum <= X) start++;
			else end--;
		}
		System.out.println(cnt);
	}
}
