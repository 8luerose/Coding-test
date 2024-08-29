package section_02;
import java.util.*;

class ex07 {
	public int solution(int n, int [] arr) {
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 1) {
				cnt++;
				sum += cnt;
			}
			else cnt = 0;
		}
		return (sum);
	}
	public static void main(String[] args) {
		ex07 T = new ex07();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.print(T.solution(n, arr));
		sc.close();
	}
}

/** 입출력
10
1 0 1 1 1 0 0 1 1 0
=> 10
 */