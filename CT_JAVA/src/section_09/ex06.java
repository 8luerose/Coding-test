package section_09;
import java.util.*;

public class ex06 {
	static int[] unf;
	public static int Find(int v) {
		if (v == unf[v]) return (unf[v]);
		else return (unf[v] = Find(unf[v]));
	}
	public static void Union(int a, int b) {
		int fa = Find(a);
		int fb = Find(b);
		if (fa != fb) unf[fa] = fb;
	}
	public static void main(String[] args) {
		//static으로 Find, Union 함수 쓸거라 Main T = new Main(); 인스턴스화 안함
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		unf = new int[N + 1];
		for (int i = 1; i <= N; i++) unf[i] = i;
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			Union(a, b);
		}
		int a = sc.nextInt();
		int b = sc.nextInt();
		int fa = Find(a);
		int fb = Find(b);
		if (fa == fb) System.out.println("YES");
		else System.out.println("NO");
		sc.close();
	}
}
/** 입출력
▣ 입력예제 1
9 7
1 2
2 3
3 4
1 5
6 7
7 8
8 9
3 8

▣ 출력예제 1
NO
*/