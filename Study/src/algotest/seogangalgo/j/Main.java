package algotest.seogangalgo.j;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int a = N/2;
		int b = N;
		while(a > 0) {
			sb.append(a).append(" ").append(b).append(" ");
			a-=1;
			b-=1;
		}
		if(a==0 && b==((N/2)+1)) {
			sb.append((N/2)+1);
		}
		System.out.println(sb.toString());
	}
}
