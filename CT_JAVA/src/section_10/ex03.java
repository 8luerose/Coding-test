package section_10;
import java.util.*;

public class ex03 {
	static int[] arr;
	static int[] dy;
	public static int solution() {
		int answer = 0;
		dy = new int[arr.length];
		dy[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i] && dy[j] > max) max = dy[j];
			}
			dy[i] = max + 1;
			answer = Math.max(answer, dy[i]);
		}
		return (answer);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(solution());
		sc.close();
	}
}
/** 입출력
8
5 3 7 8 6 2 9 4
=> 4
*/