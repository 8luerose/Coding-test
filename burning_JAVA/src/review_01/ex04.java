package review_01;
import java.util.*;

public class ex04 {
	public static ArrayList<String> solution(int N, String[] str) {
		ArrayList<String> answer = new ArrayList<>();
		for (String x : str) {
			String tmp = new StringBuilder(x).reverse().toString();
			answer.add(tmp);
		}
		return (answer);
	}

	// public static ArrayList<String> solution(int N, String[] str) {
	// 	ArrayList<String> answer = new ArrayList<>();
	// 	for (String x : str) {
	// 		char[] arr = x.toCharArray();
	// 		int lt = 0;
	// 		int rt = x.length() - 1;
	// 		while (lt < rt) {
	// 			char tmp = arr[lt];
	// 			arr[lt] = arr[rt];
	// 			arr[rt] = tmp;
	// 			lt++;
	// 			rt--;
	// 		}
	// 		String result = String.valueOf(arr);
	// 		answer.add(result);
	// 	}
	// 	return (answer);
	// }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = sc.next();
		}
		for (String x : solution(N, str)) {
			System.out.println(x);
		}
		sc.close();
	}
	
}
/** 단어 뒤집기
3
good
time
big
=>
doog
emit
gib
*/