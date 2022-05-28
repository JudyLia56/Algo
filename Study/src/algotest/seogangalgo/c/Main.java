package algotest.seogangalgo.c;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] now = new int[N+1];
		int[] old = new int[M+1];
		for (int i = 1; i <= N; i++) {
			now[i] = sc.nextInt();
		}
		for (int i = 1; i <= M; i++) {
			old[i] = sc.nextInt();
		}
		
		int max = 0;
		int idx = 0;
		for (int i = 1; i <= M; i++) {
			int a = 0;
			int b = 0;
			a = old[i];
			if(i<=N) b = now[i];
			if(a-b>max) {
				max = a-b;
				idx = i;
			}
		}
		
		long before = 0;
		for (int i = 0; i < N; i++) {
			before+=now[i];
		}
		long after = 0;
		if(idx != 0) {
			if(idx<=N) {
				now[idx]= old[idx];
				for (int i = 0; i < N; i++) {
					after+=now[i];
				}
			}else {
				after= before+old[idx];
			}
		}
		if(after-before>0) {
			System.out.println(after-before);
		}
		else {
			System.out.println("0");
		}
	}
}
