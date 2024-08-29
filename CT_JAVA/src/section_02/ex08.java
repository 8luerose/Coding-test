package section_02;
import java.util.*;

class ex08 {
	public int [] solution(int n, int [] arr) {
		int [] result = new int[n];
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 0; j < n; j++) {
				if (arr[i] < arr[j]) cnt++;
			}
			result[i] = cnt;
		}
		return (result);
	}
	public static void main(String[] args) {
		ex08 T = new ex08();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int x : T.solution(n, arr)) {
			System.out.print( x + " ");
		}
		sc.close();
	}
}

/**
5
87 89 92 100 76
=> 4 3 2 1 5
 */