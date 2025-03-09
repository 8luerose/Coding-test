package review_01;
import java.util.*;

public class ex01 {
	public static int solution(String str, char c) {
		int answer = 0;
		str = str.toUpperCase();
		c = Character.toUpperCase(c);
		// for (int i = 0; i < str.length(); i++) {
		// 	if (str.charAt(i) == c) answer++;
		// }

		for (char x : str.toCharArray()) {
			if (x == c) answer++;
		}
		return (answer);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char c = sc.next().charAt(0);
		System.out.println(solution(str, c));
		sc.close();
	}
}
/** 예시 입력
Computercooler
c
=> 2
*/
