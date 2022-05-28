package april.day0415.bj18442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int V, P, L;
	static long[] town, res, answer;
	static long minSum = Long.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		town = new long[V];
		res = new long[P];
		answer = new long[P];
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < V; i++) {
			town[i] = Long.parseLong(st.nextToken());
		}
		
		comb(0,0);
		
		System.out.println(minSum);
		for (int i = 0; i < P; i++) {
			System.out.print(answer[i]+" ");
		}
	}
	
	public static void comb(int start, int count) {
		if(count == P) {
			long sumDist = 0;
			for(int i=0; i<V; i++) {
				long minDist = Long.MAX_VALUE;
				for(int j=0; j<P; j++) {
					long dis = Math.min(Math.abs(town[i] - res[j]), Math.min(town[i], town[j])+L - Math.max(town[i], res[j]));
					if(minDist > dis) {
						minDist = dis;
					}
				}
				sumDist += minDist;
			}
			
			if (sumDist < minSum) {
				minSum = sumDist;
				answer = res.clone();
			}
			return;
		}
		for (int i = start; i < V; i++) {
			res[count] = town[i];
			comb(i+1, count+1);
			
		}
	}
}
