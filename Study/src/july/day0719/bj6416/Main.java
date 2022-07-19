package july.day0719.bj6416;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> v;
		int cnt = 1;

		while (true) {
			v = new HashMap<>();
			int edge = 0;
			while (true) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				// 종료나 다음 케이스 넘어가는거 체크
				if (start == -1 && end == -1)
					return;
				else if (start == 0 && end == 0)
					break;
				// 입력
				v.put(start, v.getOrDefault(start, 0));
				v.put(end, v.getOrDefault(end, 0) + 1);
				edge++;
			}
			int root = 0;
			boolean flag = true;
			for (int x : v.keySet()) {
				// 1. 들어오는 간선이 하나도 없는 경우 루트
				if (v.get(x) == 0)
					root++;
				// 2. 들어오는 간선이 두개 이상인 경우 트리가 아님
				else if (v.get(x) > 1) {
					flag = false;
					break;
				}
			}

			if (v.size() == 0) {
				System.out.println("Case " + cnt + " is a tree.");
			}
			//1,2번조건 체크하고 간선들의 개수=노드개수-1인지 확인(3번)
			else if (flag && root == 1 && edge == v.size() - 1) {
				System.out.println("Case " + cnt + " is a tree.");
			} else {
				System.out.println("Case " + cnt + " is not a tree.");
			}
			cnt++;
		}
	}
}
