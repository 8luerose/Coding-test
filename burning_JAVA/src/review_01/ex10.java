package review_01;
import java.util.*;

public class ex10 {
	public static int[] solution(String s, char c) {
		int len = s.length();
		int[] answer = new int[len];
		int p = 1000;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == c) {
				p = 0;
				answer[i] = 0;
			}
			else {
				p++;
				answer[i] = p;
			}
		}
		p = 1000;
		for (int j = len - 1; j >= 0; j--) {
			if (s.charAt(j) == c) {
				p = 0;
				answer[j] = 0;
			}
			else {
				p++;
				answer[j] = Math.min(answer[j], p);
			}
		}
		return (answer);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char c = sc.next().charAt(0);
		for (int x : solution(str, c))
			System.out.print(x + " ");
		sc.close();
	}
}
/** 입출력 예제
 * teachermode e
 * =>
 * 1 0 1 2 1 0 1 2 2 1 0
 */