import java.util.*;
public class CN4{
	public static void main(String args[]){
		Scanner key=new Scanner(System.in);
		System.out.println("Enter the number of vertices: ");
		int n=key.nextInt();
		int cost[][]=new int[n][n];
		System.out.println("Enter the cost matrix: ");
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.println("Enter the cost for ["+i+","+j+"]: ");
				cost[i][j]=key.nextInt();
			}
		}
		System.out.println("Enter the source vertex: ");
		int source=key.nextInt();
		bellmanFord(n, cost, source);
	}
	
	public static void bellmanFord(int n, int cost[][], int source){
		int dist[]=new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source]=0;
		for(int i=0; i<n-1; i++){
			for(int u=0; u<n; u++){
				for(int v=0; v<n; v++){
					if(dist[u]!=Integer.MAX_VALUE && dist[u]+cost[u][v]<dist[v] && cost[u][v]!=0)
						dist[v]=dist[u]+cost[u][v];
					
				}
			}
		}
		for(int u=0; u<n; u++){
				for(int v=0; v<n; v++){
					if(dist[u]!=Integer.MAX_VALUE && dist[u]+cost[u][v]<dist[v] && cost[u][v]!=0){
						//dist[v]=dist[u]+cost[u][v];
						System.out.println("Negative cycle detected!!");
						return;
					}
				}
		}
		
		System.out.println("The distances from the SRC is as follows: ");
		for(int i=0; i<dist.length; i++)
			System.out.println(i +":  "+dist[i]);
	}
}
