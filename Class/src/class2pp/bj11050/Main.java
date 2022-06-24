package class2pp.bj11050;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(comb(N,K));
		
	}
	public static int comb (int N, int K) {
		if(N == K || K == 0) return 1;
		
		return comb(N-1, K-1) + comb(N-1, K);
	}
}
