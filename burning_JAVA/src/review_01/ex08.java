package review_01;
import java.util.*;

public class ex08 {
	public static String solution(String str) {
		String answer = "NO";
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		String tmp = new StringBuilder(str).reverse().toString();
		if (str.equals(tmp)) {
			answer = "YES";
		}
		return (answer);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(solution(str));
		sc.close();
	}
}
/** 회문을 검사할 때 알파벳만 가지고 회문을 검사 + 대소문자 구분 없이 검사
 * found7, time: study; Yduts; emit, 7Dnuof
 * => YES
 */