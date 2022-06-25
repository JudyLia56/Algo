package class2pp.bj1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringBuilder sb = new StringBuilder();
		//배열의 인덱스 값을 담당할 변수
		int index = 0;
		//1~n까지의 현재 값을 담당할 변수
		int num = 1;
		
		//입력값을 변수에 저장
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		//n개의 값으로 수열을 만들기때문에 index는 0부터 n-1까지이기때문에 n보다 작은경우에 반복한다.
		while(index < n) {
			//stack이 비어있지 않다는 조건문을 꼭 넣어준다. 당연하다 stack에 머가 있어야 pop을 할테니
			if(!stack.empty() && arr[index] < stack.get(stack.size() - 1)) {
				break;
			}else if(!stack.empty() && arr[index] == stack.get(stack.size() - 1)) {
				stack.pop();
				sb.append("-").append("\n");
				index++;
			//push해줄때는 stack이 비어있어도 된다.
			}else {
				while(num <= n) {
					if(arr[index] != num) {
						stack.push(num);
						sb.append("+").append("\n");
						num++;
					}else {
						stack.push(num);
						sb.append("+").append("\n");
						num++;
						break;
					}
				}
			}
		}
		
		if(index == n) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
	}

}