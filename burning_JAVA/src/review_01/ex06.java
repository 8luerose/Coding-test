package review_01;
import java.util.*;

public class ex06 {
	public static String solution(String str) {
		String answer = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.indexOf(str.charAt(i)) == i)
				answer += str.charAt(i);
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
/** 중복 문자 제거 (가장 첫번째 발견되는 문자만 출력)
ksekkset
=> kset
*/