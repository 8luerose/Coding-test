package section_06;
import java.util.*;

public class ex01 {
	public int[] solution(int N, int[] arr) {
		for (int i = 0; i < N - 1; i++) {
			int idx = i;
			for (int j = i + 1; j < N; j++) {
				if (arr[j] < arr[idx]) {
					System.out.println("idx: " + idx + " j: " + j + " arr[j]: " + arr[j]);
					idx = j;
				}
				int tmp = arr[i];
				arr[i] = arr[idx];
				arr[idx] = tmp;
			}
		}
		return (arr);
	}
	public static void main(String[] args) {
		ex01 T = new ex01();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
		for (int x : T.solution(N, arr)) System.out.print( x + " ");
		sc.close();

	}

}

/** 입출력
6
13 5 11 7 23 15
=> 5 7 11 13 15 23
*/