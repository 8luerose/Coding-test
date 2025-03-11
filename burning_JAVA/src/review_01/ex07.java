package review_01;
import java.util.*;

public class ex07 {
	public static String solution(String str) {
		String answer = "YES";
		str = str.toUpperCase();
		int len = str.length();
		for (int i = 0; i < (len / 2); i++) {
			if (str.charAt(i) != str.charAt(len-1 - i))
				return ("NO");
		}
		return (answer);
	}

	// public static String solution(String str) {
	// 	String answer = "NO";
	// 	String tmp = new StringBuilder(str).reverse().toString();
	// 	if (str.equalsIgnoreCase(tmp) == true)
	// 		return ("YES");
	// 	return (answer);
	// }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(solution(str));
		sc.close();
	}

}
/** 회문 문자열
 * gooG
 * => YES
*/