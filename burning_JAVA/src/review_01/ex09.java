package review_01;
import java.util.*;

public class ex09 {
	// public static int solution(String str) {
	// 	int answer = 0;
	// 	for (char x : str.toCharArray()) {
	// 		if (x >= '0' && x <= '9') answer = answer * 10 + (x - '0');
	// 	}
	// 	return (answer);
	// }
	public static int solution(String str) {
		String answer = "";
		for (char x : str.toCharArray()) {
			if (Character.isDigit(x) == true) answer += x;
		}
		return (Integer.parseInt(answer)); // "3" -> Integer.parseInt("3") -> 3
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(solution(str));
		sc.close();
	}
}
/** 입출력
 * g0en2T0s8eSoft
 * => 208
*/