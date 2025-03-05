package section_09;
import java.util.*;

class Edge implements Comparable<Edge> {
	public int vex;
	public int cost;
	Edge(int vex, int cost) {
		this.vex = vex;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge other) {
		return (this.cost - other.cost);
	}
}

public class ex05 {
	static int N, M;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dist;
	public static void solution(int v) {
		PriorityQueue<Edge> PQ = new PriorityQueue<>();
		PQ.offer(new Edge(v, 0));
		dist[v] = 0;
		while (!PQ.isEmpty()) {
			Edge tmp = PQ.poll();
			int now = tmp.vex;
			int nowCost = tmp.cost;
			if (nowCost > dist[now]) continue;
			for (Edge object : graph.get(now)) {
				if (dist[object.vex] > nowCost + object.cost) {
					dist[object.vex] = nowCost + object.cost;
					PQ.offer(new Edge(object.vex, nowCost + object.cost));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new ArrayList<ArrayList<Edge>>();
		for(int i = 0; i < M; i++) {
			graph.add(new ArrayList<Edge>());
		}
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new Edge(b, c));
		}
		solution(1);
		for (int i = 2; i <= N; i++) {
			if (dist[i] != Integer.MAX_VALUE)
				System.out.println(i + ":" + dist[i]);
			else System.out.println(i + ":impossible");
		}
		sc.close();
	}
}
/** 입출력
6 9
1 2 12 1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
=> 
2 : 11
3 : 4
4 : 9
5 : 14
6 : impossible
*/