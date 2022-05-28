package may.day0521.bj14405;

import java.util.Scanner;

public class Main {
	static String str;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		int i = 0;
		while(i < str.length()) {
			if(i + 1 < str.length() && str.charAt(i) == 'p' && str.charAt(i + 1) == 'i') {
				i += 2;
			} else if(i + 1 < str.length() && str.charAt(i) == 'k' && str.charAt(i + 1) == 'a') {
				i += 2;
			} else if(i + 2 < str.length() && str.charAt(i) == 'c' && str.charAt(i + 1) == 'h' && str.charAt(i + 2) == 'u')
				i += 3;
			else {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}
}