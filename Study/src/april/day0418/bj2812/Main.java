package april.day0418.bj2812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main {
 
    static int N, K;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
 
        String num = br.readLine();
        Stack<Integer> res = process(num);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N - K; i++) {
            sb.append(res.get(i));
        }
        System.out.println(sb.toString());
    }
 
    private static Stack<Integer> process(String num) {
 
        int cnt = 0;  
        Stack<Integer> stack = new Stack<>();
 
        for (int i = 0; i < N; i++) {
            int now = num.charAt(i) - '0';
            while (cnt < K && !stack.isEmpty() && stack.peek() < now) {
                stack.pop();
                cnt++;
            }
            stack.add(now);
        }
 
        return stack;
    }
 
}
