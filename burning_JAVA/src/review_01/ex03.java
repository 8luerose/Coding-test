package review_01;
import java.util.*;

public class ex03 {
	public static String solution(String str) {
		String answer = "";
		int max = Integer.MIN_VALUE;
		String[] arr = str.split(" ");
		for (String x : arr) {
			int len = x.length();
			if (len > max) {
				max = len;
				answer = x;
			}
		}
		return (answer);
	}
	// public static String solution(String str) {
	// 	String answer = "";
	// 	int max = Integer.MIN_VALUE;
	// 	int pos;
	// 	while ((pos = str.indexOf(' ')) != -1) {
	// 		String tmp = str.substring(0, pos);
	// 		int len = tmp.length();
	// 		if (len > max) {
	// 			max = len;
	// 			answer = tmp;
	// 		}
	// 		str = str.substring(pos + 1);
	// 	}
	// 	if(str.length() > max) answer = str;

	// 	return (answer);
	// }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(solution(str));
		sc.close();
	}
}
/** 가장 긴 단어 찾기 and 가장 앞쪽에 위치한
it is time to study
-> study
*/