package april.day0413.bj1735;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a1 = sc.nextInt();
		int b1 = sc.nextInt();
		int a2 = sc.nextInt();
		int b2 = sc.nextInt();
		
		int n1 = gcd(b1, b2);
		
		int r1 = a1*(b2/n1) + a2*(b1/n1);
		int r2 = b1*b2/n1;
		
		int n2 = gcd(r1, r2);
		
		System.out.printf("%d %d",r1/n2,r2/n2);
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
/*
A와 B의 최대공약수가 B와 R(A를 B로 나눈 나머지)의 최대공약수와 같다는 규칙
*/