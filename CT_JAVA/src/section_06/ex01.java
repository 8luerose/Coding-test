package section_06;
import java.util.*;

public class ex01 {
	public int[] solution(int N, int[] arr) {
		for (int i = 0; i < N - 1; i++) {
			int idx = i;
			for (int j = i + 1; j < N; j++) {
				if (arr[j] < arr[idx]) {
					// System.out.println("idx: " + idx + " j: " + j + " arr[j]: " + arr[j]);
					idx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
			// for (int x : arr) System.out.print( x + " ");
			// System.out.println();
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

/** 배울점
1. 선택정렬 방법
    - 전체적으로 크게 한 번 돈다
	- 기준이 되는 i를 idx로 잡고, j를 i+1로 잡는다
	- j는 i+1부터 N까지 돈다
	- 만약 arr[j]가 아까 '기준이 되는 arr[idx]'보다 작으면, idx = j 한다
	- 이때, idx = j를 이해하기 쉽게 설명하자면 '교환'하는 것이 아닌 '교환할 대상'을 찾는 것이다
	- 예를 들어, 5 13 11 7 23 15에서 idx가 1이라서 arr[idx]가 13이라면 더 작은 11을 우선 찾게되고, 다시 11이 기준이 되어서 뒤에서 그것보다 작은 수를 찾는다
	- 이렇게 하면, 13 -> 11 -> 7 순으로 O(n)안에 찾을 수 있다
	- i+1 부터 N까지 한 바퀴 돌아보면서 '가장 작은 인덱스를 기억해두는 것'이다
	- for(j) 끝났으면 기억해둔 idx를 i와 교환해준다 == 나와, 남들 중 가장 작은 수를 교환해주는 것이다
	- i가 마지막까지 돌면서 정렬이 완료된다

2. i < N - 1
    - j가 i + 1부터 돌기 때문에 i가 그보다 한 단계 낮은 N-1까지만 돌아야 한다
	- 물론, i < N로 해도 괜찮다. 왜냐하면 j가 N까지 돌기 때문에 i가 N이 되면 j는 N+1이 되어서 돌지 않기 때문이다 == j < N
*/

/* 해설
1. i를 기준으로, j를 i+1부터 돌면서 가장 작은 값을 찾는다
2. 가장 작은 값을 찾으면, i와 교환한다
3. 가장 작은 값을 찾는 것은 i는 가만히 있고 arr[j]들끼리 비교해서 가장 작은 값을 기억해두었다가 교환하는 것이다
4. 즉, i는 가만히 있고, j가 돌면서 가장 작은 값을 찾아서 i와 교환하는 것이다
*/