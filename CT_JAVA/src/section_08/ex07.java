package section_08;
import java.util.*;

public class ex07 {
	int[][] dy = new int[35][35];
	public int DFS(int N, int r) {
		if (dy[N][r] > 0) return (dy[N][r]);
		if (N == r || r == 0) return 1;
		else return dy[N][r] = DFS(N - 1, r - 1) + DFS(N - 1, r);


	}
	public static void main(String[] args) {
		ex07 T = new ex07();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		System.out.println(T.DFS(N, r));
		sc.close();
	}
}
/** 입출력
33 19
=>
818809200
*/