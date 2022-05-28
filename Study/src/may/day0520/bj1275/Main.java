package may.day0520.bj1275;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static long[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		tree = new long[N * 4];

		init(1, N, 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (x > y) {
				int temp = y;
				y = x;
				x = temp;
			}

			sb.append(sum(1, N, 1, x, y) + "\n");
			update(1, N, 1, a, b);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 모든 구간합을 저장하는 메소드
	public static long init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}
	
	// 특정 구간합을 구하는 메소드
	public static long sum(int start, int end, int node, int left, int right) {
		if (end < left || right < start) {
			return 0;
		}

		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}
	
	// 특정 요소를 다른 값으로 바꾸는 메소드
	public static long update(int start, int end, int node, int idx, long val) {
		if (idx < start || idx > end) {
			return tree[node];
		}
		
		// 리프 노드를 val로 초기화.
		if (start == end) {
			return tree[node] = val;
		}
		
		// 초기화한 리프 노드의 가지 전체를 업데이트
		int mid = (start + end) / 2;
		return tree[node] = update(start, mid, node * 2, idx, val) + update(mid + 1, end, node * 2 + 1, idx, val);
	}

}
//static class SegmentTree {
//	// 세그먼트 트리를 구현할 배열
//	private long[] tree;
//	
//	// 생성자에서 세그먼트 트리의 전체노드 수 계산 (즉, 배열 길이)
//	SegmentTree(int n) {
//		// 트리 높이 계산
//		double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) + 1;
//		// 트리의 노드 수 계산
//		long treeNodeCount = Math.round(Math.pow(2, treeHeight));
//		// 트리의 길이 설정
//		tree = new long[Math.toIntExact(treeNodeCount)];
//	}
//	
//	// 세그먼트 트리의 노드값 초기화
//	long init(long[] arr, int node, int start, int end) {
//		// 세그먼트 트리의 리프노드인 경우
//		if (start == end) {
//			// 리프노드에 배열의 값 저장 후 리턴
//			return tree[node] = arr[start];
//		} else {
//			// 리프노드가 아닌 경우에는 자식노드의 값을 더해서 노드의 값 초기화 후 리턴
//			return tree[node] = init(arr, node * 2, start, (start + end) / 2)
//					+ init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
//		}
//	}
//	
//	// 배열의 특정 구간 합을 세그먼트 트리로 구하기
//	long sum(int node, int start, int end, int left, int right) {
//		// 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 속하지 않는 경우 0리턴
//		if (end < left || right < start) {
//			return 0;
//		} else if (left <= start && end <= right) {
//			// 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 속하는 경우 노드 값 리턴
//			return tree[node];
//		} else {
//			// 그 외는 2가지 경우가 존재
//			// 1. 노드가 가지는 값의 구간이 구하려고 하는 합의 구간에 일부는 속하고 일부는 속하지 않는 경우
//			// 2. 노드가 가지는 값의 구간이 구하려고 하는 합의 구간을 모두 포함하는 경우
//			// 이와 같은 경우에는 자식노드를 탐색해서 값을 리턴
//			return sum(node * 2, start, (start + end) / 2, left, right)
//					+ sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
//		}
//	}
//	
//	// 배열의 특정 인데스의 값이 변경 될 경우 세그먼트 트리의 노드 값 변경(차이 값을 더하는 방법)
//	void update(int node, int start, int end, int index, long diff) {
//		// 노드가 가지는 값의 구간에 배열의 인덱스(값이 변경 될 인덱스)가 포함되지 않을 경우7
//		if (index < start || end < index) {
//			// 아무것도 안함
//			return;
//		} else {
//			// 노드가 가지는 값의 구간에 배열의 인덱스(값이 변경 될 인덱스)가 포함되는 경우
//			// 노드의 값 + 차이값(변경할 값-기존값)
//			tree[node] = tree[node] + diff;
//			// 노드가 리프노드가 아닌 경우
//			if (start != end) {
//				// 리프노드까지 계속 자식노드를 탐색
//				update(node * 2, start, (start + end) / 2, index, diff);
//				update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
//			}
//		}
//	}
//	
//	// 배열의 특정 인데스의 값이 변경 될 경우 세그먼트 트리의 노드 값 변경(노드 값을 직접 변경)
//	long update2(int node, int start, int end, int index, long changeValue) {
//		// 노드가 가지는 값의 구간에 배열의 인덱스(값이 변경 될 인덱스)가 포함되지 않을 경우
//		if (index < start || end < index) {
//			// 트리의 노드 값 리턴
//			return tree[node];
//		} else if (start == index && end == index) {
//			// 노드가 가지는 값의 구간과 배열의 인덱스(값이 변경 될 인덱스)값이 같은 경우
//			// 노드의 값을 변경 될 값으로 변경
//			return tree[node] = changeValue;
//		} else {
//			// 노드가 가지는 값의 구간에 배열의 인덱스(값이 변경 될 인덱스)값이 포함되는 경우(같은 경우는 제외)
//			// 자식 노드를 탐색 후 값을 더해서 리턴
//			return tree[node] = update2(node * 2, start, (start + end) / 2, index, changeValue)
//					+ update2(node * 2 + 1, (start + end) / 2 + 1, end, index, changeValue);
//		}
//	}
//	
//}
