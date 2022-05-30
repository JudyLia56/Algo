package Algo_0530.create;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class solution {
    public static void main (String[]args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int testcase = Integer.parseInt(br.readLine());
    	
    	for (int t = 1; t <= testcase; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(st.nextToken());
    		int S = Integer.parseInt(st.nextToken());
    		int P = Integer.parseInt(st.nextToken());
    		
    		if(N == 0) {
    			sb.append("#").append(t).append(" 1").append("\n");
    			continue;
    		}
    		
    		Integer[] rank = new Integer[N];
    		st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < N; i++) {
				rank[i] = Integer.parseInt(st.nextToken());
			}
    		Arrays.sort(rank, Collections.reverseOrder());
    		
    		if(N == P && S <= rank[rank.length-1]) {
    			sb.append("#").append(t).append(" -1").append("\n");
    			continue;
    		}else {
    			int answer = 1;
    			for (int i = 0; i < rank.length; i++) {
					if(S < rank[i]) answer++;
					else break;
				}
    			sb.append("#").append(t).append(" ").append(answer).append("\n");
    		}
		}
    	System.out.println(sb.toString());
    }
}