package may.day0513.bj1461;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer> negative = new ArrayList<>();
		ArrayList<Integer> positive = new ArrayList<>();
		for (int i=0; i<N; i++) {
			int book = sc.nextInt();
			if (book > 0) positive.add(book);
			else negative.add(book);
		}
		Collections.sort(negative);
		Collections.sort(positive, Collections.reverseOrder());
		
		
		ArrayList<Integer> distance = new ArrayList<>();
		while(!negative.isEmpty()) {
			int temp=0; //거리
			temp = negative.remove(0);
			for (int i=1; i<M; i++) {
				if (!negative.isEmpty()) {
					negative.remove(0);
				}
			}
			distance.add(-temp);
		}
		
		while(!positive.isEmpty()) {
			int temp=0; //z거리
			temp = positive.remove(0);
			for (int i=1; i<M; i++) {
				if (!positive.isEmpty()) {
					positive.remove(0);
				}	
			}
			distance.add(temp);
		}
		
		int answer = 0;
		Collections.sort(distance); // 가장 먼 거리를 알기 위해 sort
		for (int i=0; i<distance.size(); i++) {
			// 가장 먼 거리만 편도로 이동, 남은 거리는 왕복이라 x2
			if (i == distance.size()-1) answer += distance.get(i);
			else answer += (distance.get(i)*2);
		}
		
		System.out.println(answer);
	}
}
