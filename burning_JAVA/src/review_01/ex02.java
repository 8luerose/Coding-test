package review_01;
import java.util.*;

public class ex02 {
	public static String solution(String str) {
		String answer = "";
		for (char x : str.toCharArray()) {
			if (Character.isLowerCase(x)) answer += Character.toUpperCase(x);
			else answer += Character.toLowerCase(x);

			// if (x >= 'a' && x <= 'z') answer += (char)(x - ('a' - 'A')); // '-' == Lower
			// else if (x >= 'A' && x <= 'Z') answer += (char)(x + ('a' - 'A')); // '+' == Upper
			// else answer += x;
		}
		return (answer);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(solution(str));
		sc.close();
	}
}
/** 예시입력
StuDY
=> sTUdy
*/