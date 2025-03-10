package review_01;
import java.util.*;

public class ex05 {
	public static String solution(String str) {
		String answer = "";
		char[] arr = str.toCharArray();
		int lt = 0;
		int rt = str.length() - 1;
		while (lt < rt) {
			if (!(Character.isAlphabetic(arr[lt]))) lt++;
			else if (!(Character.isAlphabetic(arr[rt]))) rt--;
			else {
				char tmp = arr[lt];
				arr[lt] = arr[rt];
				arr[rt] = tmp;
				lt++;
				rt--;
			}
		}
		answer = String.valueOf(arr);
		return (answer);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(solution(str));
		sc.close();
	}
}
/** 알파벳 뒤집기(특수문자는 그대로)
a#b!GE*T@S
= S#T!EG*b@a
*/