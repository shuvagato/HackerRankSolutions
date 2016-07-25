/*
* https://www.hackerrank.com/challenges/bfsshortreach
*/

import java.io.*;
import java.util.*;

public class Solution {


    int V;
	LinkedList<Integer> adj[];
	
	public Solution(int v) {
		// TODO Auto-generated constructor stub
		this.V = v;
		adj = new LinkedList[v];
		for(int i = 0 ; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	
	void BFS(int s) {
			
		boolean visited[] = new boolean[V];
		int[] dist = new int[V];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
				
		for(int i = 0 ; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		dist[s] = 0;
		visited[s] = true;
		
		while(!queue.isEmpty()) {
			int element = queue.poll();
			
			Iterator<Integer> i = adj[element].listIterator();
			
			while(i.hasNext()) {
				int n = i.next();
				
				if(!visited[n]) {
					queue.add(n);
					visited[n] = true;
					dist[n] = dist[element] + 6;
				}
			}			
		}		
		printSolution(dist, V);
	
	}
	
	
private void printSolution(int[] dist, int  V) {
		
		for(int i = 0 ; i < V; i++) {
			
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.print("-1 ");
			}else if(dist[i] != 0) {
				System.out.print(dist[i] + " ");
			}
			
		}
	}
	

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for(int i = 0 ; i < T; i++) {
			Solution g = new Solution(in.nextInt());
			int edge = in.nextInt();
			for(int j = 0 ; j < edge; j++) {
				g.addEdge(in.nextInt() - 1, in.nextInt() -1);
			}
			g.BFS(in.nextInt() - 1);
			System.out.println();
		}
        
        
    }
}
