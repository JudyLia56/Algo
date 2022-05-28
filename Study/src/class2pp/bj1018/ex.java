package class2pp.bj1018;

import java.math.BigInteger;
import java.util.Scanner;

public class ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger A = sc.nextBigInteger();
		BigInteger B = sc.nextBigInteger();
		
		System.out.println(A.divide(B));
		System.out.println(A.mod(B));
	}
}