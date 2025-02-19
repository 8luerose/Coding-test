package section_08;
import java.util.*;

public class ex05 {
	static int N, M;
	static int answer = Integer.MAX_VALUE;
	public void DFS(int L, int sum, Integer[] arr) {
		if (sum > M) return;
		if (L >= answer) return;
		if (sum == M) {
			answer = Math.min(answer, L);
		}
		else {
			for (int i = 0; i < N; i++) {
				DFS(L + 1, sum + arr[i], arr);
			}
		}

	}
	public static void main(String[] args) {
		ex05 T = new ex05();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		// int[] arr = new int[N];
		Integer[] arr = new Integer[N];

		for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr, Collections.reverseOrder());
		M = sc.nextInt();
		T.DFS(0, 0, arr);
		System.out.println(answer);
		sc.close();
	}
}
/** 입출력
▣ 입력
3
1 2 5
15

▣ 출력
3
*/

/** 배울점
1. DFS를 활용한 최소 동전 개수 탐색
   - DFS 함수는 L(현재까지 사용한 동전 수)와 sum(현재까지 조합된 금액)을 인자로 받아,
     목표 금액 M에 도달하는 모든 경우의 동전 조합을 탐색함

2. for 루프의 역할과 동작 원리
   - for (int i = 0; i < N; i++) { DFS(L + 1, sum + arr[i], arr); }
     * 이 for 루프는 현재 DFS 호출 단계에서 가능한 모든 동전 선택을 반복적으로 시도함
     * 각 반복마다, 현재 단계에서 선택한 동전 arr[i]의 값을 sum에 더하고, 
       동전 사용 횟수 L를 1 증가시킨 상태로 다음 재귀 단계(DFS)를 호출함
     * 이를 통해 DFS는 큰 단위부터 작은 단위까지 모든 동전 조합을 깊이 우선 탐색하며,
       목표 금액에 도달하는 최소 동전 조합을 찾게 됨

3. 탐색 효율화를 위한 가지치기와 정렬
   - if (sum > M) return; : 현재까지 조합된 금액이 목표 금액을 초과하면, 더 이상 탐색하지 않음
   - if (L >= answer) return; : 이미 사용한 동전 수 L이 현재 최소 동전 수(answer)보다 크거나 같으면, 
     이 경로는 더 이상 최소 해를 찾을 수 없으므로 탐색 중단
   - Arrays.sort(arr, Collections.reverseOrder()); 를 사용해 동전 배열을 내림차순으로 정렬하여,
     큰 단위 동전을 먼저 선택함으로써 목표 금액을 빠르게 채울 가능성이 높아짐
*/

/* 해설
[DFS 함수의 for 루프 중심 동작 원리]
1. DFS 함수 전체 동작:
   - DFS(L, sum, arr)는 현재까지 사용한 동전 수(L)와 조합된 금액(sum)을 기반으로, 
     목표 금액 M에 도달할 수 있는 모든 조합을 탐색하는 재귀 함수임.
   - 기저 조건으로, sum이 M을 초과하면 더 이상의 탐색을 중단하고, 
     현재 동전 사용 횟수(L)가 이미 구한 최소 동전 수(answer) 이상이면 탐색을 포기함.
   - 목표 금액과 정확히 일치하는 경우(sum == M)에는 answer 값을 갱신하여 최소 동전 개수를 기록함.

2. for 루프의 구체적 역할:
   - for (int i = 0; i < N; i++) 구문은 현재 DFS 호출 단계에서, 
     모든 동전 종류(0부터 N-1까지)를 하나씩 선택하는 반복문임.
   - 각 반복에서:
       a. 선택한 동전 arr[i]의 금액을 현재 합(sum)에 더함.
       b. 동전 사용 횟수 L을 1 증가시켜, 다음 단계의 DFS 호출에 반영함.
       c. DFS(L + 1, sum + arr[i], arr)를 호출하여, 
          해당 선택 이후 가능한 모든 동전 조합을 재귀적으로 탐색함.
   - 이 과정을 통해 DFS는 모든 가능한 동전 선택 경로를 하나씩 시도하며,
     목표 금액에 도달하는 최소 동전 조합을 효율적으로 찾게 됨.

3. 예시 실행 과정 (N=3, arr=[5,2,1] 내림차순, M=15):
   - DFS(0, 0, arr)에서 for 루프를 통해:
       * i=0 선택 (동전 5): DFS(1, 5, arr) 호출 → 이후 5, 5, ... 선택 시 15 달성
       * i=1 선택 (동전 2): DFS(1, 2, arr) 호출 → 목표 금액을 넘기지 못하거나 동전 수가 많아지는 경우 가지치기 적용
       * i=2 선택 (동전 1): DFS(1, 1, arr) 호출 → 비효율적 경로는 가지치기로 빠르게 종료
   - 가지치기 조건과 내림차순 정렬 덕분에, 큰 단위 동전을 우선 선택하여 최소 동전 수 해답(예: 5+5+5)을 빠르게 찾고,
     그보다 많은 동전을 사용하는 경로는 조기에 중단됨.
*/
