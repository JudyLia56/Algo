package april.day0415.bj18442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main2 { 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer st; 
	static int V, P;
	static long L, town[], res[], answer[], minSum = Long.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException { 
		st = new StringTokenizer(br.readLine()); 
		V = Integer.parseInt(st.nextToken()); 
		P = Integer.parseInt(st.nextToken()); 
		L = Long.parseLong(st.nextToken());
		
		town = new long[V];
		res = new long[P];
		answer = new long[P];
		
		st = new StringTokenizer(br.readLine()); 
		for(int v=0; v<V; v++) {
			town[v] = Long.parseLong(st.nextToken());
		}
		
		combi(0,0);
		
		System.out.println(minSum);
		for (int i = 0; i < P; i++) {
			System.out.print(answer[i]+" ");
		}
			
	}
	private static void combi(int start, int count) {
		if(count == P) {
			getDist();
			return;
		}
		for(int i=start; i<V; i++) {
			res[count] = town[i];
			combi(i+1, count+1);
		}
	}
	private static void getDist() {
		long sumDist = 0;
		for(int v=0; v<V; v++) {
			long minDist = Long.MAX_VALUE;
			for(int p=0; p<P; p++) {
				long dist = Math.min(Math.abs(town[v] - res[p]), Math.min(town[v], res[p])+L - Math.max(town[v], res[p]));
				if(minDist > dist) {
					minDist = dist;
				}
			}
			sumDist += minDist;
		}
		
		if (sumDist < minSum) {
			minSum = sumDist;
			answer = res.clone();
		}
	}
}