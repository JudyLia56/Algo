package june.day0629.bj14391;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		//배열에 입력
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M;j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		
		int answer = 0;
		//가로일때는 0 세로는 1
		for (int i = 0; i < (1<<(N*M)); i++) {
			int sum = 0;
			//가로
			for (int j = 0; j < N; j++) {
				int cur = 0;
				for (int k = 0; k < M; k++) {
					int a = j*M+k;
					if((i & (1<<a))==0) {
						cur = cur * 10 +arr[j][k];
					}else {
						sum += cur;
						cur = 0;
					}
				}
				sum+= cur;
			}
			//세로
			for (int j = 0; j < M; j++) {
				int cur = 0;
				for (int k = 0; k < N; k++) {
					int b = k*M+j;
					if((i & (1<<b))!=0) {
						cur = cur * 10 + arr[k][j];
					}
					else {
						sum += cur;
						cur = 0;
					}
				}
				sum += cur;
			}
			answer = Math.max(sum, answer);
		}
		System.out.println(answer);
	}
}
