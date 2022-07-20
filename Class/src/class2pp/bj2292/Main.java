package class2pp.bj2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
	public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int room=1;
		int count=1;
		if(N==1){
			System.out.println(1);
		}else {
			for(int i=1;N>room;i++) {
				room=(i*6)+room;
				count++;
				
			}
			System.out.println(count);
		}
	}

}