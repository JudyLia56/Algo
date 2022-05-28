package april.day0427.bj16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
	
	static class Tree{
		int x;
		int y;
		int age;
		boolean live;
		
		public Tree(int x, int y, int age, boolean live) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
			this.live = live;
		}
	}
	
	static int[][] map, energy;
	static int N, M, K;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		
		map = new int[N][N];
		energy = new int[N][N];
		
		for(int i=0; i<N; i++){
			String[] s2 = br.readLine().split(" ");
			for(int j=0; j<N; j++){
				energy[i][j] = Integer.parseInt(s2[j]);
				map[i][j] = 5;
			}
		}
		
		LinkedList<Tree> treeList = new LinkedList<>();
		for(int i=0; i<M; i++){
			String[] s3 = br.readLine().split(" ");
			int x = Integer.parseInt(s3[0]);
			int y = Integer.parseInt(s3[1]);
			int age = Integer.parseInt(s3[2]);
			treeList.add(new Tree(x-1, y-1, age, true));
		}
		
		for(int k=0; k<K; k++){
			
			LinkedList<Tree> newTreeList = new LinkedList<>();
			for(Tree t : treeList){
				if(map[t.x][t.y] >= t.age){
					map[t.x][t.y] -= t.age;
					t.age++;
				}else{
					t.live = false;
				}
			}
			
			for(Iterator<Tree> itt = treeList.iterator(); itt.hasNext();){
				Tree tree= itt.next();
				if(!tree.live){
					map[tree.x][tree.y] += tree.age/2;
					itt.remove();;
				}
			}
			
			for(Tree tree : treeList){
				if(tree.age % 5 == 0)
				for(int j=0; j<8; j++){
					int nx = tree.x + dx[j];
					int ny = tree.y + dy[j];
					if(nx>=0 && nx<N && ny>=0 && ny<N){
						newTreeList.add(new Tree(nx, ny, 1, true));
					}
				}
			}
			treeList.addAll(0, newTreeList);

			if(k==K-1) {
				System.out.println(treeList.size());
				return;
			}
			
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					map[i][j] += energy[i][j];
				}
			}
		
		}
	}
}	
