package june.day0620.bj14226;

import java.util.*;

public class Main {
    
    static boolean[][] arr = new boolean[1001][1001];
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int s = scan.nextInt();
        
        bfs(s);
    }
    
    public static void bfs(int s) {
        Queue<emoticon> q = new LinkedList<>();
        q.offer(new emoticon(0, 1, 0));
        arr[0][1] = true; 
        
        while(!q.isEmpty()) {
            emoticon current = q.poll();
            
            if(current.total == s) {
                System.out.println(current.time);
                return;
            }
            
            q.offer(new emoticon(current.total, current.total, current.time + 1)); 
            
            
            if(current.board != 0 && current.total + current.board <= s && !arr[current.board][current.total + current.board]) {
                q.offer(new emoticon(current.board, current.total + current.board, current.time + 1));
                arr[current.board][current.total + current.board] = true;
            }
            
            if(current.total >= 1 && !arr[current.board][current.total - 1]) {
                q.offer(new emoticon(current.board, current.total - 1, current.time + 1));
                arr[current.board][current.total - 1] = true;
            }
        }
    }
    
    public static class emoticon {
        int board;
        int total;
        int time;
        
        public emoticon(int board, int total, int time) {
            this.board = board;
            this.total = total;
            this.time = time;
        }
    }
}
