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

public class ex14 {
	static int N, answer = 0;
	static int[][] arr;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static Queue<Point> Q = new LinkedList<>();
	public static void BFS(int x, int y) {
		Q.offer(new Point(x, y));
		while (!Q.isEmpty()) {
			Point tmp = Q.poll();
			for (int i = 0; i < 8; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 1) {
					arr[nx][ny] = 0;
					Q.offer(new Point(nx, ny));
				}
			}
		}
	}
	public static void solution() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					answer++;
					arr[i][j] = 0;
					BFS(i, j);
				}
			}
		}
	}
	public static void main(String[] args) {
		// ex14 T = new ex14();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		solution();
		System.out.println(answer);
		sc.close();
	}
}
/** 입출력
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0
=>
5
*/