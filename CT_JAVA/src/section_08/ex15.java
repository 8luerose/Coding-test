package section_08;
import java.util.*;

class Point {
	public int x;
	public int y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class ex15 {
	static int N, M;
	static int totalPizza;
	static ArrayList<Point> house, pizza;
	static int[] combinationArr;
	static int answer = Integer.MAX_VALUE;

	public static void DFS(int L, int start) {
		if (L == M) {
			int sum = 0;
			for (Point hs : house) {
				int distMin = Integer.MAX_VALUE;
				for (int combiIdx : combinationArr) {
					distMin = Math.min(distMin
					, Math.abs(hs.x - pizza.get(combiIdx).x) + Math.abs(hs.y - pizza.get(combiIdx).y));
				}
				sum += distMin;
			}
			answer = Math.min(answer, sum);
		}
		else {
			for (int i = start; i < totalPizza; i++) {
				combinationArr[L] = i;
				DFS(L + 1, start + 1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		house = new ArrayList<>();
		pizza = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tmp = sc.nextInt();
				if (tmp == 1) house.add(new Point(i, j));
				if (tmp == 2) pizza.add(new Point(i, j));
			}
		}
		totalPizza = pizza.size();
		combinationArr = new int[M];
		DFS(0, 0);
		System.out.println(answer);
		sc.close();
	}
}
/** 입출력
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2
=> 6
*/