import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		String answer ="";
		
		if(s.equals("A+")) {
			answer="4.3";
		}else if(s.equals("A0")) {
			answer="4.0";
		}else if(s.equals("A-")) {
			answer="3.7";
		}else if(s.equals("B+")) {
			answer="3.3";
		}else if(s.equals("B0")) {
			answer="3.0";
		}else if(s.equals("B-")) {
			answer="2.7";
		}else if(s.equals("C+")) {
			answer="2.3";
		}else if(s.equals("C0")) {
			answer="2.0";
		}else if(s.equals("C-")) {
			answer="1.7";
		}else if(s.equals("D+")) {
			answer="1.3";
		}else if(s.equals("D0")) {
			answer="1.0";
		}else if(s.equals("D-")) {
			answer="0.7";
		}else if(s.equals("F")) {
			answer="0.0";
		}
		
		System.out.println(answer);
	}
}
