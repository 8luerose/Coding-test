package section_10;
import java.util.*;

public class ex02 {
	static int[] dy;
	public static int solution(int N) {
		dy[1] = 1;
		dy[2] = 2;
		for (int i = 3; i <= N + 1; i++) {
			dy[i] = dy[i - 2] + dy[i - 1];
		}
		return (dy[N + 1]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dy = new int[N + 1 + 1];
		System.out.println(solution(N));
		sc.close();
	}
}
/** 입출력
7
=> 34
*/

// 주의, 개울까지 건너가야 하는 문제. 마지막 돌계단 도착 횟수를 묻는 것이 아님. -> 돌계단 + 1 == 개울까지 건넜을 때 를 세어야함. 따라서 dy N + 자연수 + 개울1, for도 마지막 돌 + 1==개울까지