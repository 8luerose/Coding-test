package section_08;
import java.util.*;

class Point {
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class ex12 {
	static int M, N;
	static int[][] arr, dist;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Point> Q = new LinkedList<>();
	public void BFS() {
		while (!Q.isEmpty()) {
			Point tmp = Q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && arr[nx][ny] == 0) {
					arr[nx][ny] = 1;
					Q.offer(new Point(nx, ny));
					dist[nx][ny] = dist[tmp.x][tmp.y] + 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		ex12 T = new ex12();
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N + 1][M + 1];
		dist = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1) Q.offer(new Point(i, j));
			}
		}
		T.BFS();

		boolean flag = true;
		int answer = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (arr[i][j] == 0) flag = false;
			}
		}
		
		if (flag == true) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					answer = Math.max(answer, dist[i][j]);
				}
			}
			System.out.println(answer);
		}
		else System.out.println(-1);
		sc.close();
	}
}
/** 입출력
6 4
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1
=>
4
*/