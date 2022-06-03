package class2pp.bj1929;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] prime = new boolean[N+1];
		
		prime[0]=prime[1]=true;
		int sqrt = (int)Math.sqrt(N);
		for (int i = 2; i <= sqrt; i++) {
			for (int j = 2; j <= N/i; j++) {
				if(prime[i*j]==true) continue;
				else prime[i*j]=true;
			}
		}
		for (int i = M; i <= N; i++) {
			if(prime[i]==false) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
